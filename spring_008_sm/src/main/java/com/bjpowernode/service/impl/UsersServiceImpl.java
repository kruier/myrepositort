package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.UsersMapper;
import com.bjpowernode.pojo.Accounts;
import com.bjpowernode.pojo.Users;
import com.bjpowernode.service.AccountsService;
import com.bjpowernode.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service  //交给Spring去创建对象
//@Transactional(propagation = Propagation.REQUIRED)
public class UsersServiceImpl implements UsersService {
    //切记切记:在所有的业务逻辑层中一定会有数据访问层的对象
    /**
     *         //1.读取核心配置文件
     *         InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
     *         //2.创建工厂对象
     *         SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
     *         //3.取出sqlSession
     *         sqlSession = factory.openSession(true);//自动提交事务
     *         //4.取出动态代理的对象,完成接口中方法的调用,实则是调用xml文件中相的标签的功能
     *         uMapper = sqlSession.getMapper(UsersMapper.class);
     */
    @Autowired
    UsersMapper usersMapper;

    @Autowired
    AccountsService accountsService;

    @Override
    public int insert(Users users) {
        int num = usersMapper.insert(users);
        System.out.println("用户增加成功!num="+num);

        //调用帐户的增加操作,调用的帐户的业务逻辑层的功能
        num = accountsService.save(new Accounts(300,"王五","帐户好的呢!"));
        return num;
    }
}
