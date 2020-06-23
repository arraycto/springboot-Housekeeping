package com.briup.jz.utils;

/**
 * @Description ：自定义异常
 * @Author tj
 * @Date 2020/6/12
 */
public class CustomerException extends RuntimeException{

    public CustomerException() {
        super();
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerException(Throwable cause) {
        super(cause);
    }

    protected CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
