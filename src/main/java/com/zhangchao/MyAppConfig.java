package com.zhangchao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhangchao.HelloService;

/**
 * SpringBoot 推荐的配置
 *
 */
@Configuration
public class MyAppConfig {
	
	private final static Logger logger = LoggerFactory.getLogger("MyAppConfig");
	
    @Bean
    public HelloService helloService(){
        logger.info("测试往容器中添加Bean....");
        return new HelloService();
    }

}
