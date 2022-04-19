package com.bjpowernode.test;

import com.bjpowernode.pojo.Accounts;
import com.bjpowernode.pojo.Users;
import com.bjpowernode.service.AccountsService;
import com.bjpowernode.service.UsersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class MyTest {
    @Test
    public void testUsers(){
        //创建容器并启动
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_service.xml");
        //取出UsersServiceImpl
        UsersService uService = (UsersService) ac.getBean("usersServiceImpl");
        int num = uService.insert(new Users(100,"张三","123"));
        System.out.println(num);
    }
    @Test
    public void testAccounts(){
        //创建容器并启动
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_service.xml");
        AccountsService accountsService = (AccountsService) ac.getBean("accountsServiceImpl");
        System.out.println(accountsService.getClass());
        accountsService.save(new Accounts(206,"李四6","帐户安全6666!"));
    }

    @Test
    public void testTrans(){
        //创建容器并启动
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_trans.xml");
        //取出UsersServiceImpl
        UsersService uService = (UsersService) ac.getBean("usersServiceImpl");
        int num = uService.insert(new Users(100,"张三","123"));
        System.out.println(num);
    }
}
