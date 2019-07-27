package com.zhangchao.mapper;

import org.apache.ibatis.annotations.Select;

import com.zhangchao.bean.Department;

public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department getDeptById(Integer id);
}
