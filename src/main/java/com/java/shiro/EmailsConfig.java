package com.java.shiro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailsConfig {

    @Bean
    public JavaMailSenderImpl javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setUsername("1499192230@qq.com");
        javaMailSender.setPassword("xgxijmlyakklgcdb");
        javaMailSender.setHost("smtp.qq.com");
        return javaMailSender;
    }
}
