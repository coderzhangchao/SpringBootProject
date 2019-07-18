package com.zhangchao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhangchao.HelloService;

/**
 * SpringBoot 推荐的配置
 *
 */
@Configuration
public class MyAppConfig {
	
    @Bean
    public HelloService helloService(){
        System.out.println("������@Bean����������������...");
        return new HelloService();
    }

}
