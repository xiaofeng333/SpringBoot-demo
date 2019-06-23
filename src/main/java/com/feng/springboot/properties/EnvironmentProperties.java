package com.feng.springboot.properties;

import org.springframework.beans.factory.annotation.Value;

public class EnvironmentProperties {

    /**
     * 获取环境变量
     */
    @Value("${windir}")
    private String windir;

    public String getWindir() {
        return windir;
    }

    public void setWindir(String windir) {
        this.windir = windir;
    }
}
