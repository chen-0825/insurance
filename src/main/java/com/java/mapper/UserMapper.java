package com.java.mapper;

import com.java.pojo.ShiroUser;


public interface UserMapper {

    ShiroUser find(String name);
    String findRole(int id);
}
