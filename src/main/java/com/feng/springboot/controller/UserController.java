package com.feng.springboot.controller;

import com.feng.springboot.constant.StatusCode;
import com.feng.springboot.entity.User;
import com.feng.springboot.repository.UserRepository;
import com.feng.springboot.reqrep.rep.Result;
import com.feng.springboot.reqrep.req.UserCreateReq;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ApiOperation("新增新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "电话", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "string", paramType = "query")

    })
    @PostMapping("/save")
    public Result<String> save(@Validated @RequestBody UserCreateReq userReq) {
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        userRepository.save(user);
        return new Result<>(StatusCode.SUCESS);
    }

    @ApiOperation("校验, get请求")
    @GetMapping("/find")
    public Result<Iterable> find() {
        return new Result<>(StatusCode.SUCESS, userRepository.findAll());
    }
}
