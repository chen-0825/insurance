package com.java.mapper;

import com.java.pojo.ShiroUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserMapper {

    @Select("select * from shiro_user where name = #{name}")
    ShiroUser find(String name);

    @Select("select role from shiro_user where id = #{id}")
    String findRole(int id);

    @Insert("insert into shiro_user(`name`,password,email) values (#{name},#{password},#{email})")
    int insert(ShiroUser shiroUser);

    @Update("update shiro_user set password=#{password} where name=#{name}")
    int update(ShiroUser shiroUser);
}
