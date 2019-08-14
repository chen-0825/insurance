package com.java.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/backstageIndex")
    public String index(){
        System.out.println("主页");
        return "/backstage/index";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        System.out.println("登录");
        return "/backstage/login";
    }

    @RequestMapping("/backstageLogin")
    public String login(String name,String password, Model model){

        /*  使用shiro编写认证操作  */
//        1.获取Subject
        Subject subject = SecurityUtils.getSubject();
//        2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try {
//        3.执行登录方法
            subject.login(token);
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
        }
//        判断是否存在用户
        if(subject.isAuthenticated()){
            System.out.println("认证成功");
            token.clear();
            return "redirect:/backstageIndex";
        }else{
            token.clear();
            return "/backstage/login";
        }
    }
}
