package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
            @Param("columnNam1e")
            String columnName,
            @Param("columnValue")
            String columnValue);

    //按指定的条件进行多条件查询
    List<Users> getByCondition(Users users);

    //有选择的更新
    int updateBySet(Users users);

    //查询多个指定id的用户信息
    List<Users> getByIds(Integer []arr);

    //批量删除
    int deleteBatch(Integer []arr);

    //批量增加
    int insertBatch(List<Users> list);

    //查询指定日期范围内的用户
    List<Users> getByBirthday(Date begin, Date end);

    //入参是map
    List<Users> getByMap(Map map);

    //返回值是map(一行)
    Map getReturnMap(Integer id);

    //返回多行的map
    List<Map> getMulMap();

}
