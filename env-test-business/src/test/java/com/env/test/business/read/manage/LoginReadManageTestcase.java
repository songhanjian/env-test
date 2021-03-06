package com.env.test.business.read.manage;

import com.env.test.business.write.manage.LoginWriteManage;
import com.env.test.model.po.Login;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 16-9-28.
 */
public class LoginReadManageTestcase extends TestCase {
    private LoginReadManage loginReadManage;



    public LoginReadManageTestcase() {
        System.setProperty("global.config.path","/home/shj/dev/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("env-test-business/spring-service.xml");
        loginReadManage = (LoginReadManage) applicationContext.getBean("loginReadManageImpl");
    }

    public void testLogin(){
        try {
            Login login = new Login();
            login.setAccount("ody");
            login.setPassword("ody123");
            Integer result = loginReadManage.login(login);
            Assert.assertEquals(1,result.intValue());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
