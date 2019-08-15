package com.java;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsuranceApplicationTests {

    @Test
    public void contextLoads() {
        Md5Hash admin = new Md5Hash("123", "admin", 3);
        System.out.println(admin.toHex());
    }

}
