package com.shusheng.config;

/**
 * 自定义异常类
 * @author 刘闯
 * @date 2021/4/1.
 */
public class BaseException extends RuntimeException {

    /**
     * 错误信息
     */
    private String msg;
    /**
     * 错误编码
     */
    private String code;


    public BaseException() {
    }

    public BaseException(String msg) {
        this.msg = msg;
    }

    public BaseException(String msg, String code) {
        this.code = code;
        this.msg = msg;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    protected BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
