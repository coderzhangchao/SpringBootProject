package com.zhangchao.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener implements ServletContextListener {
    
	private final static Logger logger = LoggerFactory.getLogger(MyListener.class);
	
	@Override
    public void contextInitialized(ServletContextEvent sce) {
        
        logger.info("contextInitialized...web应用启动.....contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
        logger.info("contextDestroyed...当前web项目销毁....contextDestroyed");
    }
}
