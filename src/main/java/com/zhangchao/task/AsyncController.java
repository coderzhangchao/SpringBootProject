package com.zhangchao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用异步任务的步骤:
 * 1、在启动类上面添加注解:        @EnableAsync
 * 2、在需要异步执行的方法上添加注解: @Async -- 则方法则被放置到boot内部的线程池中，开启新线程执行
 */
@RestController
public class AsyncController {
	
	@Autowired
	AsyncService asyncService;
	
	
	@GetMapping("/async")
	public String asyncTask() {
		asyncService.hello();
		return "success";
	}
}
