package com.zhangchao;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;


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
 * @MapperScan(value = "com.zhangchao.mapper") -- 开启全局mapper扫描,
    *     每个mapper接口上就不用加 @Mapper注解
 *
 */
@MapperScan(value = "com.zhangchao.mapper")
@SpringBootApplication
@EnableCaching
public class Main {

	private final static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		// 测试项目日志
		logger.info("项目启动成功..........");
	} 
}
