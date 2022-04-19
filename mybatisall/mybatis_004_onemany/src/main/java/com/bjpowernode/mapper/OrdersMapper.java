package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Orders;

/**
 *
 */
public interface OrdersMapper {
    //根据主键查询订单,并同时查询下此订单的客户信息
    Orders getById(Integer id);
}
