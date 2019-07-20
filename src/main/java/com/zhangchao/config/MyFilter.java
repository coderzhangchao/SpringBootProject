package com.zhangchao.config;

import javax.servlet.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MyFilter implements Filter {
	
	private final static Logger logger = LoggerFactory.getLogger(MyFilter.class);
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("MyFilter process...filter......filter...");
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
