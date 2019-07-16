package com.zhangchao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	/**
	 * 1°¢≤‚ ‘œÓƒø¥ÓΩ®
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
