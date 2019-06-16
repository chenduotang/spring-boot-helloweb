package com.cc.controller;

import com.cc.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello spring";
    }

    //无需在配置视图解析器，thymeleaf自动帮你渲染
    //查出一些数据在页面显示
    @RequestMapping("/success")
    public String Thymeleaf(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("user", Arrays.asList("zhangsan", "lisi", "wanwu"));
        System.out.println("thymeleaf is working");
        return "success";
    }

    /**
     * 访问首页
     * @return
     */
    /*@RequestMapping({"/","login.html"})
    public String index(){
        return "login";
    }*/
}
