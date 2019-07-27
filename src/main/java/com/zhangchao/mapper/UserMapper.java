package com.zhangchao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhangchao.bean.User;

/**
 * 指定这是一个操作数据库的mapper
 * @author fmr
 *
 */
@Mapper
public interface UserMapper {
	
	@Select("select * from t_user")
	public List<User> getUsers();
	
	@Select("select * from t_user where id = #{id}")
	public User getUserById(Integer id);
	
	@Delete("delete from t_user where id = #{id}")
	public int deleteUserById(Integer id);
	
	/**
	    *   允许JDBC支持自动生成主键，需要驱动兼容。 
                *   如果设置为true则这个设置强制使用自动生成主键，尽管一些驱动不能兼容但仍可正常工作（比如 Derby）。
	 * generate -- 生成
	 * useGeneratedKeys --- 生成主键
	 */
	@Options(useGeneratedKeys = true,keyProperty = "id")
	@Insert("insert into t_user (username,loginacct,userpswd,email,createtime) "
			+ "values (#{userName},#{loginAcct},#{userPswd},#{email},#{createTime})")
	public int insertUser(User user);
	
	@Update("update t_user set username = #{userName} where id = #{id}")
	public int updateDept(User user);
	
	public int deleteEmpById(Integer id);
}
