package com.zhangchao.controller;

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
}
