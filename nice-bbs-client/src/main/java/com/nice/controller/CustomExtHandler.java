package com.nice.controller;

import com.nice.config.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @author nice
 */
@RestControllerAdvice
public class CustomExtHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomExtHandler.class);


    //捕获全局异常,处理所有不可知的异常
    @ExceptionHandler(value=Exception.class)
    Object handleException(Exception e, HttpServletRequest request){
        LOG.error("url {}, msg {}",request.getRequestURL(), e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }

    /**
     * 功能描述: 处理自定义异常类
     * @return
     *
     */
    @ExceptionHandler(value = MyException.class)
    Object handleMyException(MyException e, HttpServletRequest request){
        //进行页面跳转
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error.html");
//        modelAndView.addObject("msg", e.getMessage());
//        return modelAndView;

        //f返回json数据
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }
}
