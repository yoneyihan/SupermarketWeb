package com.hd.supermarket.web;

import com.hd.supermarket.dto.SingleResult;
import com.hd.supermarket.error.AppException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 李金荣
 * @date 2018/11/1 17:07
 */
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = AppException.class)
    public Object AppExecption(AppException e, HttpServletResponse response){
        response.setStatus(e.getCode());
        return SingleResult.build(e.getResult());
    }

}
