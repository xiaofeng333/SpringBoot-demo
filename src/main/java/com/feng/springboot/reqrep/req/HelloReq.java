package com.feng.springboot.reqrep.req;

import javax.validation.constraints.NotNull;

public class HelloReq {

    @NotNull(message = "姓名不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
