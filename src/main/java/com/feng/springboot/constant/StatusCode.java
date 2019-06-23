package com.feng.springboot.constant;

public enum StatusCode {
    SUCESS(0, "sucess", "成功"),
    PARAM_ERROR(400, "param error", "参数错误");

    private int code;
    private String message;
    private String desc;

    StatusCode(int code, String message, String desc) {
        this.code = code;
        this.message = message;
        this.desc = desc;
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
}
