package com.bjpowernode.test;

import com.bjpowernode.controller.UsersController;
import com.bjpowernode.pojo.Users;
import org.junit.Test;

/**
 *
 */
public class MyTest {
    @Test
    public void testInsertUsers(){
        //?创建谁的对象  创建UsersController对象
        UsersController usersController = new UsersController();
        int  num = usersController.insert(new Users(100,"张三",22));
        System.out.println(num);
    }
}
