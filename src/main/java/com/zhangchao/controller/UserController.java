package com.zhangchao.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zhangchao.bean.User;
import com.zhangchao.mapper.UserMapper;

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		User user = userMapper.getUserById(id);
		return user;
	}
	
	@GetMapping("/delu/{id}")
	public Integer deleUser(@PathVariable("id") Integer id) {
		int result = userMapper.deleteEmpById(id);
		return result;
	}
	
	@GetMapping("/user/alluser")
	public List<User> getUsers(){
		List<User> users = userMapper.getUsers();
		for(User u : users) {
			logger.info(u.toString());
		}
		return users;
	}
	
	@GetMapping("/user/{userName}/{loginAcct}/{userPswd}/{email}/{createTime}")
    public User insertUser(
    		@PathVariable("userName") String userName,
    		@PathVariable("loginAcct") String loginAcct,
    		@PathVariable("userPswd") String userPswd,
    		@PathVariable("email") String email,
    		@PathVariable("createTime") String createTime){
        
		User u = new User();
		u.setUserName(userName);
		u.setLoginAcct(loginAcct);
		u.setUserPswd(userPswd);
		u.setEmail(email);
		u.setCreateTime(createTime);
		
		int result = userMapper.insertUser(u);
		logger.info("查询结果：result====="+result);
		
		/*
		 * u 中已经将 自增生成的 id 封装到对象中了
		 * @Options(useGeneratedKeys = true,keyProperty = "id")
		 */
        return u;
    }
}
