package com.common.lock;

import cn.hutool.core.util.RandomUtil;
import com.common.exception.DistributedLockedException;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Description 文件注释
 * <p>
 * Version		1.0.0
 *
 * @author chenyouhong
 * <p>
 * Date 2020/11/26 下午3:39
 */
@Slf4j
@Component
public class DistributedLockTemplateImpl implements DistributedLockTemplate {
    private static final long DEFAULT_WAIT_TIME = 30;
    private static final long DEFAULT_TIMEOUT = 5;
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;

    @Autowired
    private RedissonClient redisson;

    @Override
    public <T> T lock(DistributedLockCallback<T> callback, boolean fairLock, boolean discardToLock) {
        return lock(callback, DEFAULT_TIMEOUT, DEFAULT_TIME_UNIT, fairLock, discardToLock);
    }

    @Override
    public <T> T lock(DistributedLockCallback<T> callback, long leaseTime, TimeUnit timeUnit, boolean fairLock, boolean discardToLock) {
        RLock lock = getLock(callback.getLockName(), fairLock);
        String flag = RandomUtil.randomNumbers(8);
        try {
            log.info("--->目前锁状态,tag:{},lock:{},state:{}", flag, callback.getLockName(),
                    lock.isLocked() ? "已锁" : "未锁");
            if (discardToLock && lock.isLocked()) {
                log.info("--->已抛弃执行任务,tag:{},lock:{}", flag, callback.getLockName());
                throw new DistributedLockedException("当前业务编号正在执行业务，请勿同时使用相同的业务编号进行业务操作。");
            }
            lock.lock(leaseTime, timeUnit);

            log.info("--->加锁成功,tag:{},lock:{}", flag, callback.getLockName());
            return callback.process();
        } finally {
            if (lock != null && lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
                log.info("--->释放锁成功,tag:{},lock:{}", flag, callback.getLockName());
            }
        }
    }

    @Override
    public <T> T tryLock(DistributedLockCallback<T> callback, boolean fairLock) {
        return tryLock(callback, DEFAULT_WAIT_TIME, DEFAULT_TIMEOUT, DEFAULT_TIME_UNIT, fairLock);
    }

    @Override
    public <T> T tryLock(DistributedLockCallback<T> callback, long waitTime, long leaseTime, TimeUnit timeUnit, boolean fairLock) {
        RLock lock = getLock(callback.getLockName(), fairLock);
        String flag = RandomUtil.randomNumbers(8);
        try {
            if (lock.tryLock(waitTime, leaseTime, timeUnit)) {
                log.info("--->加锁成功,tag:{},lock:{}", flag, callback.getLockName());
                return callback.process();
            }
            log.info("--->尝试获取锁超时,tag:{},锁名：{},超时时间：{}", flag, callback.getLockName(), waitTime);
        } catch (InterruptedException e) {
            log.info("--->获取锁中断异常：{}", callback.getLockName(), e);
            Thread.currentThread().interrupt();
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
                log.info("--->释放锁成功,tag:{},lock:{}", flag, callback.getLockName());
            }
        }
        return null;
    }

    private RLock getLock(String lockName, boolean fairLock) {
        RLock lock;
        if (fairLock) {
            lock = redisson.getFairLock(lockName);
        } else {
            lock = redisson.getLock(lockName);
        }
        return lock;
    }

}
