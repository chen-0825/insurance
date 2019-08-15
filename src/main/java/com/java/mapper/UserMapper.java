package com.java.mapper;

import com.java.pojo.ShiroUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {

    @Select("select * from shiro_user where name = #{name}")
    ShiroUser find(String name);

    @Select("select role from shiro_user where id = #{id}")
    String findRole(int id);

    @Insert("insert into shiro_user(`name`,password,email) values (#{name},#{password},#{email})")
    int insert(ShiroUser shiroUser);

}
