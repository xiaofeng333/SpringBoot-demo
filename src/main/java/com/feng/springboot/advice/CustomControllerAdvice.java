package com.feng.springboot.advice;

import com.feng.springboot.constant.StatusCode;
import com.feng.springboot.reqrep.rep.Result;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 如有必要, 可重写ResponseEntityExceptionHandler中handleException方法的所有异常处理方法, 以形成统一返回
 */
@ControllerAdvice("com.feng.springboot.controller")
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    /**
     * 方法内抛出异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handlerControllerException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new Result<>(StatusCode.PARAM_ERROR, ex.getMessage()), getStatus(request));
    }

    /**
     * 处理绑定异常
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new Result<>(StatusCode.PARAM_ERROR, ex.getMessage()), status);
    }

    /**
     * 获取请求的状态码
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
