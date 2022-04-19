package com.bjpowernode.test;

import com.bjpowernode.mapper.UsersMapper;
import com.bjpowernode.pojo.Users;
import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.tools.Dump;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public class MyTest {

    SqlSession sqlSession;
    //动态代理对象
    UsersMapper uMapper;
    //日期的格式化刷子
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    @Before
    public void openSqlSession() throws IOException {
        //1.读取核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.取出sqlSession
        sqlSession = factory.openSession(true);//自动提交事务
        //4.取出动态代理的对象,完成接口中方法的调用,实则是调用xml文件中相的标签的功能
        uMapper = sqlSession.getMapper(UsersMapper.class);
    }

    @After
    public void closeSqlSession(){
        sqlSession.close();
    }

    @Test
    public void testGetAll(){

        System.out.println(uMapper.getClass());
        //就是在调用接口的方法,mybatis框架已经为我们把功能代理出来了.
        List<Users> list = uMapper.getAll();
        list.forEach(users -> System.out.println(users));
    }
    @Test
    public void testUpdate() throws ParseException {
        Users u = new Users(7,"haha66",sf.parse("2000-01-01"),"2","北京大兴亦庄66");
        int num = uMapper.update(u);
        System.out.println(num);
        //切记切记切记:手工提交事务
        sqlSession.commit();
    }
    @Test
    public void testById(){
        Users u = uMapper.getById(27);
        System.out.println(u);
    }
    @Test
    public void testGetByName(){
        List<Users> list = uMapper.getByName("小");
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testGetByNameOrAddress(){
        List<Users> list = uMapper.getByNameOrAddress("address","市");
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testGetByNameGood(){
        List<Users> list = uMapper.getByNameGood("小");
        list.forEach(users -> System.out.println(users));
    }


    @Test
    public void testInsert() throws ParseException {
        Users u = new Users("lala66",sf.parse("2001-01-01"),"2","大兴");
        int num = uMapper.insert(u);
        System.out.println(num);
        sqlSession.commit();
        System.out.println(u);
    }

    @Test
    public void testDelete() throws ParseException {
       int num = uMapper.delete(3);
        System.out.println(num);
       // sqlSession.commit();
    }

    @Test
    public void testUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-","").substring(20));
    }

    @Test
    public void testCache() throws ParseException {
        //第一次取id=5的用户
        Users u1 = uMapper.getById(5);
        System.out.println("第一次取出的用户u1:"+u1);
        System.out.println("***********************************");

        //执行更新操作
        Users u = new Users(27,"djdj",sf.parse("2009-01-01"),"2","北京大兴亦庄djdj");
        int num = uMapper.update(u);
        sqlSession.commit();

        Users u2 = uMapper.getById(5);
        System.out.println("第一次取出的用户u1:"+u2);
        System.out.println(u1 == u2);
    }
}
