package com.bjpowernode.controller;

import com.bjpowernode.pojo.Users;
import com.bjpowernode.service.UsersService;
import com.bjpowernode.service.impl.UsersServiceImpl;

/**
 *  界面层
 */
public class UsersController {

    //如何去访问业务逻辑层,就是创建对象
    //切记切记:所有的界面层都会有业务逻辑层的对象
    public UsersService usersService = new UsersServiceImpl();

    //界成层的功能实现,对外提供访问的功能
    public int insert(Users users){
        return usersService.insert(users);
    }
}
