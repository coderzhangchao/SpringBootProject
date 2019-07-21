package com.zhangchao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler{
	
	private final static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
	
	
	@ExceptionHandler(Exception.class)
		
	@ResponseBody
	ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
		logger.info("进入 到==MyExceptionHandler==方法内部...");
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
	}
	
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}
	
    /*
     * 1、浏览器客户端返回的都是json
     */
	/*
	    @ResponseBody
	    @ExceptionHandler(UserNotExistException.class)
	    public Map<String,Object> handleException(Exception e){
	        Map<String,Object> map = new HashMap<>();
	        map.put("code","user.notexist");
	        map.put("message",e.getMessage());
	        return map;
	    }
    */
	
	/**
	 * 浏览器和客户端自适应
	 * @param e
	 * @param request
	 * @return
	 */
	/*
	    @ExceptionHandler(Exception.class)
	    public String handleException(Exception e, HttpServletRequest request){
	    	logger.info("进入 到==MyExceptionHandler==方法内部...");
	        Map<String,Object> map = new HashMap<String,Object>();
	        //传入我们自己的错误状态码 4xx 5xx，否则就不会进入定制错误页面的解析流程
	        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	        logger.info("statusCode========"+statusCode);
	        request.setAttribute("javax.servlet.error.status_code",500);
	        map.put("code","user.notexist");
	        map.put("message","用户出错啦");
	        request.setAttribute("ext",map);
	        //转发到/error
	        return "forward:/error";
	    }
    */
}
