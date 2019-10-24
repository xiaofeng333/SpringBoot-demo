package com.feng.springboot.controller;

import com.feng.springboot.component.House;
import com.feng.springboot.constant.StatusCode;
import com.feng.springboot.reqrep.rep.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private House house;

    @ApiOperation("测试例子, get请求")
    @GetMapping("/say")
    public String say() {
        return "say hello!";
    }

    @ApiOperation("校验是否使用自定义注解注入成功, get请求")
    @GetMapping("/desc")
    public Result<String> desc() {
        house.describe();
        return new Result<>(StatusCode.SUCESS);
    }
}
