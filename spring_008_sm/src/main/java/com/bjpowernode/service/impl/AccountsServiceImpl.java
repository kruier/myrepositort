package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.AccountsMapper;
import com.bjpowernode.pojo.Accounts;
import com.bjpowernode.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
//@Transactional(propagation = Propagation.REQUIRED,//事务的传播特性
//        noRollbackForClassName = "ArithmeticException", //指定发生什么异常不回滚,使用的是异常的名称
//        noRollbackFor = ArithmeticException.class,//指定发生什么异常不回滚,使用的是异常的类型
//        rollbackForClassName = "",//指定发生什么异常必须回滚
//        rollbackFor = ArithmeticException.class,//指定发生什么异常必须回滚
//        timeout = -1, //连接超时设置,默认值是-1,表示永不超时
//        readOnly = false, //默认是false,如果是查询操作,必须设置为true.
//        isolation = Isolation.DEFAULT//使用数据库自已的隔离级别
//)
@Transactional(propagation = Propagation.NEVER)
public class AccountsServiceImpl implements AccountsService {
    //一定会有数据访问层的对象
    @Autowired
    AccountsMapper accountsMapper;
    @Override
    public int save(Accounts accounts) {
        int num = 0;
        num = accountsMapper.save(accounts);
        System.out.println("增加帐户成功!num="+num);
        //手工抛出异常
        System.out.println(1/0);
        return num;
    }
}
