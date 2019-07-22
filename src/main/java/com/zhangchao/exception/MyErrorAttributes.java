package com.zhangchao.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
	
	private final static Logger logger = LoggerFactory.getLogger(MyErrorAttributes.class);
	
    //返回值的map就是页面和json能获取的所有字段
	@Override
    public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, boolean includeStackTrace) {
		logger.info("进入 到==MyErrorAttributes==方法内部...");
		Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company","zhangchao");

        //我们的异常处理器携带的数据
        @SuppressWarnings("unchecked")
		Map<String,Object> ext = (Map<String, Object>) requestAttributes.getAttribute("ext", 0);
        map.put("ext",ext);
        
        return map;
    }
}
