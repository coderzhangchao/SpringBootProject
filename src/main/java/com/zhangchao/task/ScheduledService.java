package com.zhangchao.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务的步骤：
 * 1、启动类上面添加注解：@EnableScheduling
 * 2、定时 任务上面添加注解：@Scheduled(cron="")
 * @author fmr
 *
 */
@Service
public class ScheduledService {
	
	/**
	 * second(秒), minute（分）, hour（时）, day of month（日）, month（月）, day of week（周几）
	 * 0 * * * * MON-FRI
	 * 0 0/5 14,18 * * ? --- 每天14点整，和18点整，每隔5分钟执行一次
	 */
	@Scheduled(cron="0 0/5 14,18 * * ?")
	public void scheduledMethod() { //定时执行的方法
		System.out.println("定时任务执行了....");
	}
}
