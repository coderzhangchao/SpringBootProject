package com.zhangchao.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangchao.service.DataSourceTestService;

@Controller
public class HelloController {
	
	private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private DataSourceTestService dataSourceTest;
	
	/**
	 * 1、测试项目搭建
	 * @return
	 * @throws SQLException 
	 */
	@ResponseBody
	@RequestMapping("/hello")
	public String sayHello() throws SQLException {
		dataSourceTest.contextLoads();
		String name = dataSourceTest.queryTab();
		name = name.equals("") ? "查询异常" : name;
		logger.info("......查询数据库结果===="+name);
		return "Hello World!";
	}
	
	/**
	 * 2、测试模板引擎
	 * @param map
	 * @return
	 */
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
