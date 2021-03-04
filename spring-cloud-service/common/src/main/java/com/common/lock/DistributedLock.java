package com.common.lock;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Description 分布式锁注解
 * <p>
 * 调用同一个类的带注解的方法，该注解将不生效，请注意使用方法
 *
 * @author chenyouhong
 * @date 2020/11/26 下午3:39
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistributedLock {
    /**
     * 锁的名称。
     * 如果lockName可以确定，直接设置该属性。
     */
    String lockName() default "";

    /**
     * lockName前缀
     * 默认资金方锁名称
     */
    String lockNamePre() default "zy-fin:lock";

    /**
     * lockName后缀
     */
    String lockNamePost() default "";

    /**
     * 获得锁名时拼接前后缀用到的分隔符
     *
     * @return
     */
    String separator() default ":";

    /**
     * 获取注解的方法参数列表的某个参数对象的某个属性值来作为lockName。因为有时候lockName是不固定的
     * 当param不为空时，可以通过argNum参数来设置具体是参数列表的第几个参数，不设置则默认取第一个
     */
    String param() default "";

    /**
     * 将方法第argNum个参数作为锁
     */
    int argNum() default 0;

    /**
     * 如果已被锁定，直接放弃等待及执行,tryLock = false时才有效
     * 高并发下，同一台机器，多个执行线程可能同时执行到lock.lock，
     * 这时只能依靠超时时间机制
     */
    boolean discardToLock() default true;

    /**
     * 是否使用公平锁。
     * 公平锁即先来先得。
     */
    boolean fairLock() default false;

    /**
     * 是否使用尝试锁。当超过waitTime时间时，放弃等待及执行
     */
    boolean tryLock() default false;

    /**
     * 最长等待时间。
     * 该字段只有当tryLock()返回true才有效。
     */
    long waitTime() default 30L;

    /**
     * 锁超时时间。
     * 超时时间过后，锁自动释放。
     */
    long leaseTime() default 10L;

    /**
     * 时间单位。默认为秒。
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

}