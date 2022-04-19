package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Customer;

/**
 *
 */
public interface CustomerMapper {

    //根据客户的id查询客户所有信息并同时查询该客户名下的所有订单
    Customer getById(Integer id);
}
