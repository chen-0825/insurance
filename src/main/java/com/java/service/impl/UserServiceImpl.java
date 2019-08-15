package com.java.service.impl;

import com.java.mapper.UserMapper;
import com.java.pojo.ShiroUser;
import com.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    public ShiroUser find(String name) {
        return usermapper.find(name);
    }

    public String findRole(int id) {
        return usermapper.findRole(id);
    }

    public int insert(ShiroUser shiroUser) {
        return usermapper.insert(shiroUser);
    }

    public int update(ShiroUser shiroUser) {
        return usermapper.update(shiroUser);
    }
}