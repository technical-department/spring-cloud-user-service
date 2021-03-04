package com.common.lock;

import java.util.concurrent.TimeUnit;

/**
 * Description 分布式锁操作模板
 * <p>
 * Version		1.0.0
 *
 * @author chenyouhong
 * <p>
 * Date	      2020/11/26 下午3:39
 */
public interface DistributedLockTemplate {


    /**
     * 使用分布式锁，使用锁默认超时时间。
     *
     * @param callback
     * @param fairLock      是否使用公平锁
     * @param discardToLock 未获取到锁时是否直接抛弃任务
     * @return
     */
    <T> T lock(DistributedLockCallback<T> callback, boolean fairLock, boolean discardToLock);

    /**
     * 使用分布式锁。自定义锁的超时时间
     *
     * @param callback
     * @param leaseTime     锁超时时间。超时后自动释放锁。
     * @param timeUnit
     * @param fairLock      是否使用公平锁
     * @param discardToLock 已被锁直接抛弃
     * @return
     */
    <T> T lock(DistributedLockCallback<T> callback, long leaseTime, TimeUnit timeUnit, boolean fairLock, boolean discardToLock);

    /**
     * 尝试分布式锁，使用锁默认等待时间、超时时间。
     *
     * @param callback
     * @param fairLock 是否使用公平锁
     * @param <T>
     * @return
     */
    <T> T tryLock(DistributedLockCallback<T> callback, boolean fairLock);

    /**
     * 尝试分布式锁，自定义等待时间、超时时间。
     *
     * @param callback
     * @param waitTime  获取锁最长等待时间
     * @param leaseTime 锁超时时间。超时后自动释放锁。
     * @param timeUnit
     * @param fairLock  是否使用公平锁
     * @param <T>
     * @return
     */
    <T> T tryLock(DistributedLockCallback<T> callback, long waitTime, long leaseTime, TimeUnit timeUnit, boolean fairLock);
}
