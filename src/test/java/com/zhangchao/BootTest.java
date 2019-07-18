package com.zhangchao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangchao.bean.Person;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BootTest {

	@Autowired
	Person person;
	
	@Autowired
	ApplicationContext ioc;
	
	/**
	 * 测试@ImportResource(locations= {"classpath:beans.xml"})
	 */
	@Test
	public void testHelloService() {
		boolean isTrue = ioc.containsBean("helloService");
		System.out.println(isTrue);
	}
	
	@Test
	public void contextLoads() {
		System.out.println(person);
	}
}
