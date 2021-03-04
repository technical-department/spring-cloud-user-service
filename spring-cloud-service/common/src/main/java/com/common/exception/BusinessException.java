package com.common.exception;

/**
 * 项目名称：spring-cloud-service
 * 类 名 称：BusinessException
 * 类 描 述：TODO
 * 创建时间：2021/2/10 下午7:31
 * 创 建 人：chenyouhong
 */
public class BusinessException extends Exception {

    private String code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

}
