package com.cc.config;

import com.cc.MyLocaleResolver.MyLocaleResolver;
import com.cc.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 使用WebMvcConfigurationSupport可以来扩展springMvc的功能
 */
@Configuration
public class MymvcConfig implements WebMvcConfigurer {
    //添加视图映射器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/success").setViewName("success");
    }


    //WebMvcConfigurationAdaper会一起起作用
    @Bean//将组件注册在容器中
    public WebMvcConfigurer WebMvcConfigurer(){
        WebMvcConfigurer Support=new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
            }

//            @Override
//            //注册拦截器
//            public void addInterceptors(InterceptorRegistry registry) {
//                //那么静态资源，springboot已经做好了静态资源映射，不会拦截
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("login.html","/","/user/login");
//            }
        };
        return Support;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
