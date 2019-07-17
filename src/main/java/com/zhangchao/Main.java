package com.zhangchao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
    *   标注在某个类上，表示这是一个Spring Boot的配置类
 * @SpringBootConfiguration
 * 
 * @EnableAutoConfiguration
 * @ComponentScan(excludeFilters = {
 * 	@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
 * 	@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) 
 * })
 * 
 */
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	} 
}
