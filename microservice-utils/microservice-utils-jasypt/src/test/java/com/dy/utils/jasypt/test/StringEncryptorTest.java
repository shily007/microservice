package com.dy.utils.jasypt.test;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dy.utils.jasypt.JasyptConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class StringEncryptorTest {
	
	static {
		System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
	}
	
    @Autowired
    private StringEncryptor encryptor;
 
    @Test
    public void getPass() {
        
        String username = encryptor.encrypt("admin");
        String password = encryptor.encrypt("123456");
        String akId = encryptor.encrypt("xxx");
        String akPwd = encryptor.encrypt("xxx");
 
        System.out.println("-------");
        System.out.println();
 
        System.out.println("数据库用户名:"+username);
        System.out.println("数据库密码:"+password);
        System.out.println("短信ak Id:"+akId);
        System.out.println("短信ak 密码:"+akPwd);
 
 
        System.out.println();
 
    }

}
