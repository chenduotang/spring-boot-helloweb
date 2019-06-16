package com.cc.controller;

import com.cc.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器,主要是处理json数据响应
 */
@ControllerAdvice
public class MyexceptionHandler {
    //1、浏览器和服务器都是返回json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handeException(Exception e){
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("massage",e.getMessage());
//        return map;
//    }
    //2、自己适应效果，准发到/error，让basicErrorController进行处理
    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public String handeException(Exception e,HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        //传入我们自己的错误状态码，4xx,5xx
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("massage","用户怎么不见了！！");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
