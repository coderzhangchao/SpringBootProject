package com.zhangchao.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zhangchao.component.LoginHandlerInterceptor;
import com.zhangchao.component.MyLocaleResolver;

/**
 * 使用WebMvcConfigurer可以来扩展SpringMVC的功能
 * @EnableWebMvc   不要接管SpringMVC
 * @author fmr
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
	
	/**
	 * 处理国际化资源的本地URL设置
	 * @return
	 */
	@Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }
	
	/*
	 * 向容器中注册拦截器
	 * SpringBoot 1.X 已经做好了静态资源映射,此处不用去进行排除
	 * SpringBoot 2.X 需要排除
	 * exclude.add("/asserts/**");
	 * 
	 * 处理请求前判断该用户有没有登陆
	 */
    @Override
	public void addInterceptors(InterceptorRegistry registry) {
    	List<String> exclude = new ArrayList<String>();//不拦截的列表
        exclude.add("/index.html");
        exclude.add("/user/login");
        exclude.add("/");
        exclude.add("/asserts/**");
    	registry.addInterceptor(new LoginHandlerInterceptor())
			    .addPathPatterns("/**")
			    .excludePathPatterns(exclude);
	}


	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	/*
    	 * super.addViewControllers(registry);
    	 * 浏览器发送 / 请求来到 login
    	 */
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
	
	/*
	 * 注册自定义的Servlet
	 */
    @Bean
    public ServletRegistrationBean<HttpServlet> myServlet(){
        ServletRegistrationBean<HttpServlet> registrationBean = 
        		new ServletRegistrationBean<HttpServlet>(new MyServlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
    
    /*
     * 注册过滤器
     */
    @Bean
    public FilterRegistrationBean<Filter> myFilter(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<Filter>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }
    
    /*
     * 注册监听器
     */
    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> myListener(){
        ServletListenerRegistrationBean<ServletContextListener> registrationBean = 
        		new ServletListenerRegistrationBean<ServletContextListener>(new MyListener());
        return registrationBean;
    }
}
