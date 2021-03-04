package com.common.lock;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.exceptions.StatefulException;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Description 切面
 * <p>
 * Version		1.0.0
 *
 * @author chenyouhong
 * <p>
 * Date	      2020/11/26 下午3:39
 */
@Slf4j
@Aspect
@Component
public class DistributedLockAspect {

    @Autowired
    private DistributedLockTemplate lockTemplate;

    @Pointcut("@annotation(DistributedLock)")
    public void lockPointcut() {
        //切面定义
    }

    @Around(value = "lockPointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws NoSuchMethodException {

        //切点所在的类
        Class targetClass = pjp.getTarget().getClass();
        //使用了注解的方法
        String methodName = pjp.getSignature().getName();

        Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getMethod().getParameterTypes();

        Method method = targetClass.getMethod(methodName, parameterTypes);

        Object[] arguments = pjp.getArgs();

        final String lockName = getLockName(method, arguments);

        log.info("--->准备加锁：{}", lockName);

        return lock(pjp, method, lockName);
    }

    public String getLockName(Method method, Object[] args) {
        Objects.requireNonNull(method);
        DistributedLock annotation = method.getAnnotation(DistributedLock.class);

        String lockName = annotation.lockName();
        String param = annotation.param();

        if (StrUtil.isBlank(lockName)) {
            if (args.length > 0 && StrUtil.isNotBlank(param)) {
                Object arg = annotation.argNum() > 0 ? args[annotation.argNum() - 1] : args[0];
                lockName = String.valueOf(getParam(arg, param));
            } else if (annotation.argNum() > 0) {
                lockName = args[annotation.argNum() - 1].toString();
            }
        }

        if (StrUtil.isNotBlank(lockName)) {
            String preLockName = annotation.lockNamePre();
            String postLockName = annotation.lockNamePost();
            String separator = annotation.separator();

            StringBuilder lName = new StringBuilder();
            if (StrUtil.isNotBlank(preLockName)) {
                lName.append(preLockName).append(separator);
            }
            lName.append(lockName);
            if (StrUtil.isNotBlank(postLockName)) {
                lName.append(separator).append(postLockName);
            }

            lockName = lName.toString();

            return lockName;
        }

        throw new IllegalArgumentException("无法生成lockName!");
    }

    /**
     * 从方法参数获取数据
     *
     * @param param
     * @param arg   方法的参数数组
     * @return
     */
    public Object getParam(Object arg, String param) {
        if (StrUtil.isNotBlank(param) && arg != null) {
            try {
                Object property = BeanUtil.getProperty(arg, param);
                if (property == null) {
                    throw new IllegalArgumentException(arg + "没有属性" + param + "或未实现get方法。");
                }
                return property;
            } catch (Exception e) {
                throw new ValidateException("从方法参数获取数据出现异常，请检查", e);
            }
        }
        return null;
    }

    public Object lock(ProceedingJoinPoint pjp, Method method, final String lockName) {

        DistributedLock annotation = method.getAnnotation(DistributedLock.class);

        boolean fairLock = annotation.fairLock();

        boolean tryLock = annotation.tryLock();

        boolean discardToLock = annotation.discardToLock();

        if (tryLock) {
            return tryLock(pjp, annotation, lockName, fairLock);
        } else {
            return lock(pjp, annotation, lockName, fairLock, discardToLock);
        }
    }

    public Object lock(ProceedingJoinPoint pjp, DistributedLock annotation, final String lockName, boolean fairLock, boolean discardToLock) {
        long leaseTime = annotation.leaseTime();
        TimeUnit timeUnit = annotation.timeUnit();

        return lockTemplate.lock(new DistributedLockCallback<Object>() {
            @Override
            public Object process() {
                return proceed(pjp);
            }

            @Override
            public String getLockName() {
                return lockName;
            }
        }, leaseTime, timeUnit, fairLock, discardToLock);
    }

    public Object tryLock(ProceedingJoinPoint pjp, DistributedLock annotation, final String lockName, boolean fairLock) {

        long waitTime = annotation.waitTime();
        long leaseTime = annotation.leaseTime();
        TimeUnit timeUnit = annotation.timeUnit();

        return lockTemplate.tryLock(new DistributedLockCallback<Object>() {
            @Override
            public Object process() {
                return proceed(pjp);
            }

            @Override
            public String getLockName() {
                return lockName;
            }
        }, waitTime, leaseTime, timeUnit, fairLock);
    }

    public Object proceed(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (StatefulException e) {
            throw e;
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}