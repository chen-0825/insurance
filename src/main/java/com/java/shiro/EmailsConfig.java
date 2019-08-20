package com.java.shiro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailsConfig {

    @Bean
    public JavaMailSenderImpl javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setUsername("15272452553@163.com");
        javaMailSender.setPassword("chy0825");
        javaMailSender.setHost("smtp.163.com");
        return javaMailSender;
    }
}
