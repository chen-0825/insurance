package com.java.controller;

import com.java.pojo.ShiroUser;
import com.java.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private int i;

    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSenderImpl sendMail;

    @RequestMapping("/backstageIndex")
    public String index(){
        return "/backstage/index";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "/backstage/login";
    }

    @RequestMapping("/backstageLogin")
    public String login(String name,String password,HttpServletRequest request){

        /*  使用shiro编写认证操作  */
//        1.获取Subject
        Subject subject = SecurityUtils.getSubject();
//        2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try {
//        3.执行登录方法
            subject.login(token);
        }catch (UnknownAccountException e){
//            model.addAttribute("msg","用户名不存在");
        }catch (IncorrectCredentialsException e){
//            model.addAttribute("msg","密码错误");
        }
//        判断是否存在用户
        if(subject.isAuthenticated()){
            System.out.println("认证成功");
            token.clear();
            request.getSession().setAttribute("ShiroUser",userService.find(name));
            return "redirect:/sendEmails";
        }else{
            token.clear();
            return "/backstage/login";
        }
    }

//    注册
    @RequestMapping("/register")
    public String register(ShiroUser shiroUser){
        Md5Hash admin = new Md5Hash(shiroUser.getPassword(), shiroUser.getName(), 3);
        shiroUser.setPassword(admin.toHex());
        userService.insert(shiroUser);
        return "/backstage/login";
    }

//    发送邮箱
    @RequestMapping("/sendEmails")
    public String sendEmails(HttpServletRequest request){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("验证码");
        i = (int) ((Math.random() * 9 + 1) * 100000);
        message.setText("验证码:"+i);
        message.setFrom("15272452553@163.com");
        ShiroUser shiroUser = (ShiroUser)request.getSession().getAttribute("ShiroUser");
        System.out.println(shiroUser);
        message.setTo(shiroUser.getEmail());
        sendMail.send(message);
        return "/backstage/emails";
    }

//    邮箱正确进入首页
    @RequestMapping("/verification")
    public String verification(String pwd){
        if (i == Integer.parseInt(pwd)){
            return "redirect:/backstageIndex";
        }
        return "/backstage/emails";
    }

}