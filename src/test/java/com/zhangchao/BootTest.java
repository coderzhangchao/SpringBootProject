package com.zhangchao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangchao.bean.Person;

/**
 * SpringBoot��Ԫ����;
    *    �����ڲ����ڼ�ܷ�������Ʊ���һ�������Զ�ע��������Ĺ��ܡ�
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BootTest {

	@Autowired
	Person person;
	
	@Test
	public void contextLoads() {
		System.out.println(person);
	}
}
