package com.java.pojo;

import lombok.Data;

@Data
public class ShiroUser {
    private int id;
    private String name;
    private String password;
    private String role;
    private String email;
}
