package com.cc.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入我们自定义的属性
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace, RequestAttributes attributes) {
        Map<String,Object> map=super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","chenduotang");
        //我们的异常处理器携带的数据
        Map<String,Object> ext= (Map<String, Object>) attributes.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }
}
