package com.feng.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Validated注解 校验属性配置是否正确, 当错误时, 无法正常启动
 */
@ConfigurationProperties("project.spring")
@Validated
public class ProjectProperties {

    /**
     * 注入list
     */
    private List<String> list;

    /**
     * 注入map
     */
    private Map<String, String> map;

    @NotNull
    private String validateStr;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getValidateStr() {
        return validateStr;
    }

    public void setValidateStr(String validateStr) {
        this.validateStr = validateStr;
    }
}
