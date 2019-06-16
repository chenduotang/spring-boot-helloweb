package com.cc.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器检查是否登录
 * 如何检查登录，就是把登录好的用户放在session中
 */
public class LoginHandlerInterceptor  implements HandlerInterceptor {
    @Override
    //目标方法执行之前,要注意的是写完了之后一定要记得配置出来
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("loginUser");
        if(user == null){
            //未登录,返回登录页面
            request.setAttribute("message","没有权限请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
