package com.zhangchao.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhangchao.entity.Dept;
import com.zhangchao.entity.Emp;

@Repository
public class EmployeeDao {

	private static Map<Integer, Emp> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Emp>();
		employees.put(1001, new Emp(1001, "E-AA", "aa@163.com", 1, new Dept(101, "D-AA")));
		employees.put(1002, new Emp(1002, "E-BB", "bb@163.com", 1, new Dept(102, "D-BB")));
		employees.put(1003, new Emp(1003, "E-CC", "cc@163.com", 0, new Dept(103, "D-CC")));
		employees.put(1004, new Emp(1004, "E-DD", "dd@163.com", 0, new Dept(104, "D-DD")));
		employees.put(1005, new Emp(1005, "E-EE", "ee@163.com", 1, new Dept(105, "D-EE")));
	}
	
	private static Integer initId = 1006;
	
	public void save(Emp employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	//查询所有员工
	public Collection<Emp> getAll(){
		return employees.values();
	}
	
	public Emp get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
