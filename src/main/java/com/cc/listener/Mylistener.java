package com.cc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Mylistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...are process");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed...are process");
    }
}
