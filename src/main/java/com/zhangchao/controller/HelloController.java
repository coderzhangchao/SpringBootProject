package com.zhangchao.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	/**
	 * 1、测试项目搭建
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hello")
	public String sayHello() {
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
