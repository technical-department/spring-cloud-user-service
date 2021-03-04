package com.common.exception;

import cn.hutool.core.util.StrUtil;

/**
 * Description
 * 分布式锁已被抢占异常
 * <p>
 * Version		1.0.0
 *
 * @author chenyouhong <p>
 * Date	   2020/11/26 下午3:39
 */
public class DistributedLockedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DistributedLockedException(Throwable e) {
        super(e);
    }

    public DistributedLockedException(String message) {
        super(message);
    }

    public DistributedLockedException(String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public DistributedLockedException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DistributedLockedException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }

}
