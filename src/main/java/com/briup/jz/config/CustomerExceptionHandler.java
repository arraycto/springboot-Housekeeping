package com.briup.jz.config;

import com.briup.jz.utils.CustomerException;
import com.briup.jz.utils.Message;
import com.briup.jz.utils.MessageUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @program: app01
 * @description: 统一异常处理类，对控制异常抛出的异常同意处理
 * @author: charles
 * @create: 2019-03-13 21:03
 **/
@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(value =  Exception.class) // 捕获 Controller 中抛出的指定类型的异常，也可以指定其他异常
    public <E> Message handler(Exception exception){
        exception.printStackTrace();
        if(exception instanceof CustomerException){
            return MessageUtil.error(exception.getMessage());
        } else if (exception instanceof DataIntegrityViolationException) {
        	return MessageUtil.error("数据库错误");
        }
        return MessageUtil.error("后台接口异常！");
    }
}
