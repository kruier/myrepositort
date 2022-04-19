package com.bjpowernode.dao;

import com.bjpowernode.pojo.Users;

/**
 *  数据访问层的实现类
 */
public class UsersMapperImpl implements UsersMappr {
    @Override
    public int insert(Users u) {
        System.out.println(u.getUname()+"用户增加成功!");
        return 1;
    }
}
