package com.cc.config;

import com.cc.filter.Myfilter;
import com.cc.listener.Mylistener;
import com.cc.servlet.Myservlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServletConfig {
    //注册三大组件

    /**
     * Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean myServelt(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new Myservlet(),"/Myservlet");
           return registrationBean;
    }
    /**
     * Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean=new  FilterRegistrationBean();
        registrationBean.setFilter(new Myfilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/Myservlet"));
        return registrationBean;
    }
    /**
     * Listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean registrationBean =new ServletListenerRegistrationBean<Mylistener>(new Mylistener());
        return registrationBean;
    }
}
