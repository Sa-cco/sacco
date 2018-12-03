package com.example.demo.common;


import com.example.demo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
@ResponseBody
public class GlobalExceptionHadler {

    private static final Logger logger=  LoggerFactory.getLogger(GlobalExceptionHadler.class);

    @ExceptionHandler
    @ResponseStatus
    public JsonResult handleUnexpectedServer(Exception ex){
        logger.error("系统异常",ex);
        return new JsonResult("500","请联系管理人员");
    }

}
