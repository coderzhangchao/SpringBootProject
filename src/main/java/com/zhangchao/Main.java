package com.zhangchao;

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
//@ImportResource(locations= {"classpath:beans.xml"})
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	} 
}
