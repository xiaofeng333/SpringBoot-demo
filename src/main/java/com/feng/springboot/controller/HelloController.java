package com.feng.springboot.controller;

import com.feng.springboot.reqrep.req.HelloReq;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation("测试例子, get请求")
    @GetMapping("/say")
    public String say() {
        return "say hello!";
    }

    @ApiOperation("校验, get请求")
    @GetMapping("/validate")
    public String validate(@Validated HelloReq req) {
        return "spring" + req.getName();
    }
}
