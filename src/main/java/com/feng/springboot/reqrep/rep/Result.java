package com.feng.springboot.reqrep.rep;

import com.feng.springboot.constant.StatusCode;

public class Result<T> {
    private int code;
    private String message;
    private String desc;
    private T data;

    public Result(StatusCode statusCode, T data) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.desc = statusCode.getDesc();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
