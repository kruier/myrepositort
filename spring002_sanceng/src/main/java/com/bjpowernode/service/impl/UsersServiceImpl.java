package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UsersMapperImpl;
import com.bjpowernode.dao.UsersMappr;
import com.bjpowernode.pojo.Users;
import com.bjpowernode.service.UsersService;

/**
 *  业务逻辑层的实现类
 */
public class UsersServiceImpl implements UsersService {

    //切记切记:在所有的业务逻辑层中都必定有数据访问层的对象
    private UsersMappr usersMappr = new UsersMapperImpl();

    @Override
    public int insert(Users users) {
        //添加更复杂的业务,但是我们现在没有复杂业务
        int oo=usersMappr.insert(users);

        return oo;
    }
}
