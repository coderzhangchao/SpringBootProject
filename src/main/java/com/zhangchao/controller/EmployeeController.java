package com.zhangchao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zhangchao.dao.DepartmentDao;
import com.zhangchao.dao.EmployeeDao;
import com.zhangchao.entity.Department;
import com.zhangchao.entity.Employee;

import java.util.Collection;


/**
 * RestFul API：
    *   实验功能                                         请求URI      请求方式
    *   查询所有员工                                 emps         GET
    *   查询某个员工(来到修改页面)      emp/1        GET
    *   来到添加页面                                 emp          GET
    *   添加员工                                         emp          POST
    *   来到修改页面（员工信息回显） emp/1        GET
    *   修改员工                                         emp          PUT
    *   删除员工                                         emp/1        DELETE
 */
@Controller
public class EmployeeController {
    
	
	private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /*
     * 查询所有员工返回列表页面
     * RestfulAPI 之 Get请求...
     * <a class="nav-link active" href="#" th:href="@{/emps}"
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        /*
         * thymeleaf默认就会拼串
         * classpath:/templates/xxxx.html
         */
        return "emp/list";
    }

    /*
                *   来到员工添加页面
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    
    /*
     * 员工添加
     * <form th:action="@{/emp}" method="post">
     * SpringMVC自动将请求参数和入参对象的属性进行一一绑定
     * 要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
    	logger.info("====保存的员工信息====："+employee);
        //保存员工
        employeeDao.save(employee);
        /*
         * redirect: 表示重定向到一个地址  /代表当前项目路径
         * forward: 表示转发到一个地址
         */ 
        return "redirect:/emps";
    }

    /*
     * 来到修改页面，查出当前员工，在页面回显
     * <a class="btn btn-sm btn-primary" th:href="@{/emp/}+${emp.id}">编辑</a>
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        /*
         * 回到修改页面(add是一个修改添加二合一的页面)
         */
        return "emp/add";
    }

    /*
     * 员工修改,需要提交员工id
     * <form th:action="@{/emp}" method="post">
     * <input type="hidden" name="_method" value="put" th:if="${emp!=null}"/>
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
    	logger.info("修改的员工数据："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /*	
     * 员工删除
     * $(".deleteBtn").click(function(){
	 * $("#deleteEmpForm").attr("action",$(this).attr("del_uri")).submit();
	 *   return false;
     * });
     * <td>
	 * 	 <a class="btn btn-sm btn-primary" th:href="@{/emp/}+${emp.id}">编辑</a>
	 *   <button th:attr="del_uri=@{/emp/}+${emp.id}" class="btn btn-sm btn-danger deleteBtn">删除</button>
	 * </td>
     * <form id="deleteEmpForm"  method="post">
	 * 	 <input type="hidden" name="_method" value="delete"/>
	 * </form>
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        logger.info("into deleteEmployee method...");
    	employeeDao.delete(id);
        return "redirect:/emps";
    }



}
