package com.zhangchao.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	
	private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);
	
	@Async
	public void hello() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("处理数据中......");
	}
}
