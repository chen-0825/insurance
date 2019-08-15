package com.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
//不需再配置中配mybatis.mapper-locations=classpath:com/java/mapper/*.xml和在mapper层@Mapper @Repository
@MapperScan("com.java.mapper")
public class InsuranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceApplication.class, args);
    }
}  
