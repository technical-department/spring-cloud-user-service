package com.common.lock;

/**
 * Description 分布式锁回调接口
 * <p>
 * Version		1.0.0
 *
 * @author chenyouhong
 * <p>
 * Date	      2020/11/26 下午3:39
 */
public interface DistributedLockCallback<T> {
    /**
     * 调用者必须在此方法中实现需要加分布式锁的业务逻辑
     *
     * @return
     */
    T process();

    /**
     * 得到分布式锁名称
     *
     * @return
     */
    String getLockName();
}
