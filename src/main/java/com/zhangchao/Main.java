package com.zhangchao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
    *   ��ע��ĳ�����ϣ���ʾ����һ��Spring Boot��������
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
