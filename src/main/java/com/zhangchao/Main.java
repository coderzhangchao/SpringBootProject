package com.zhangchao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @SpringBootConfiguration
 * 
 * @EnableAutoConfiguration
 * @ComponentScan(excludeFilters = {
 * 	@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
 * 	@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) 
 * })
 * 
 * @ImportResource(locations= {"classpath:beans.xml"})
 *
 */
@SpringBootApplication
public class Main {

	private final static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		// 测试项目日志
		logger.info("项目启动成功..........");
	} 
}
