package com.zhangchao.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zhangchao.entity.Dept;


@Repository
public class DepartmentDao {

	private static Map<Integer, Dept> departments = null;
	
	static{
		departments = new HashMap<Integer, Dept>();
		departments.put(101, new Dept(101, "D-AA"));
		departments.put(102, new Dept(102, "D-BB"));
		departments.put(103, new Dept(103, "D-CC"));
		departments.put(104, new Dept(104, "D-DD"));
		departments.put(105, new Dept(105, "D-EE"));
	}
	
	public Collection<Dept> getDepartments(){
		return departments.values();
	}
	
	public Dept getDepartment(Integer id){
		return departments.get(id);
	}
	
}
