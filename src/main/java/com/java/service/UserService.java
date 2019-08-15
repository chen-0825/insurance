package com.java.service;

import com.java.pojo.ShiroUser;

public interface UserService {


    ShiroUser find(String name);

    String findRole(int id);

    int insert(ShiroUser shiroUser);

}
