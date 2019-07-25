package com.zhangchao.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * 默认是用class com.zaxxer.hikari.HikariDataSource作为数据源；
 * 数据源的相关配置都在DataSourceProperties里面。
 * 常用数据源：HikariDataSource、BasicDataSource(DBCP)
 * 阿里的Druid虽然性能没有 HikariDataSource 性能好，但由于有成套的监控系统所以应用也比较广泛
 * 配置文件中使用type属性指定自定义的数据源
 * @author fmr
 *
 */
@Service
public class DataSourceTestService {
	
	private final static Logger logger = LoggerFactory.getLogger(DataSourceTestService.class);
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String queryTab() {
		List<Map<String,Object>> users = jdbcTemplate.queryForList("select * from t_user where id = 1");
		String name = "";
		try {
			Map<String,Object> map = users.get(0);
			name = map.get("username").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	/**
	 * 测试数据库连接
	 * 自动配置在 DataSourceConfiguration 类里面
	 * @throws SQLException
	 */
	public void contextLoads() throws SQLException {
		/*
		 * com.zaxxer.hikari.HikariDataSource
		 * 
		 * 自定义后：
		 * com.alibaba.druid.pool.DruidDataSource
		 */
		dataSource.getClass();
		logger.info(dataSource.getClass().toString());
		Connection connection = dataSource.getConnection();
		logger.info(connection.toString());
		connection.close();

	}
}
