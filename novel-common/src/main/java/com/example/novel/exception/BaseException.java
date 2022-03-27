package com.example.novel.exception;
/**
 * 自定义异常
 *
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public BaseException(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
