package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  数据访问层的接口,规定的数据库中可进行的各种操作
 */
public interface UsersMapper {
    //查询全部用户信息
    List<Users> getAll();

    //根据用户主键查用户
    Users getById(Integer id);

    //根据用户名模糊查询用户
    List<Users> getByName(String name);

    //优化后的模糊查询
    List<Users> getByNameGood(String name);
    //用户的更新
    int update(Users users);
    //增加用户
    int insert(Users users);
    //根据主键删除用户
    int delete(Integer id);
    //模糊用户名和地址查询
    List<Users> getByNameOrAddress(
            @Param("columnName")
            String columnName,
            @Param("columnValue")
            String columnValue);
}
