package com.bjpowernode.test;

import com.bjpowernode.mapper.UsersMapper;
import com.bjpowernode.pojo.Users;
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
import java.util.*;

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
        sqlSession = factory.openSession();
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
       int num = uMapper.delete(1);
        System.out.println(num);
        sqlSession.commit();
    }

    @Test
    public void testUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-","").substring(20));
    }

    @Test
    public void testGetByCondition() throws ParseException {
        Users u = new Users();
        u.setSex("1");
        u.setUserName("小");
        u.setAddress("市");
       // u.setBirthday(sf.parse("2001-01-01"));
        List<Users> list = uMapper.getByCondition(u);
        list.forEach(uu-> System.out.println(uu));
    }

    @Test
    public void testUpdateSet() throws ParseException {
       Users u = new Users();
       u.setId(30);
//       u.setUserName("星期一");
//       u.setSex("1");
      // u.setAddress("亦庄");
        int num = uMapper.updateBySet(u);
        System.out.println(num);
        //切记切记切记:手工提交事务
        sqlSession.commit();
    }

    @Test
    public void testGetByIds(){
        Integer []array = {2,4,6};
        List<Users> list = uMapper.getByIds(array);
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testDeleteBatch(){
        Integer []array = {2,4,6};
       int num = uMapper.deleteBatch(array);
       sqlSession.commit();
        System.out.println(num);
    }

    @Test
    public void testInsertBatch() throws ParseException {
        Users u1 = new Users("aa",sf.parse("2002-05-05"),"2","朝阳a");
        Users u2 = new Users("bb",sf.parse("2002-05-05"),"2","朝阳b");
        Users u3 = new Users("cc",sf.parse("2002-05-05"),"2","朝阳c");
        Users u4 = new Users("dd",sf.parse("2002-05-05"),"2","朝阳d");
        List<Users> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        int  num = uMapper.insertBatch(list);
        sqlSession.commit();
        System.out.println(num);
    }

    @Test
    public void testGetBirthday() throws ParseException {
      Date begin = sf.parse("1999-01-01");
      Date end = sf.parse("1999-12-31");
      List<Users> list = uMapper.getByBirthday(begin,end);
      list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testGetByMap() throws ParseException {
        Date begin = sf.parse("1999-01-01");
        Date end = sf.parse("1999-12-31");
        Map map = new HashMap<>();
        map.put("birthdayBegin",begin);
        map.put("birthdayEnd", end);
        List<Users> list = uMapper.getByMap(map);
        list.forEach(users -> System.out.println(users));

    }

    @Test
    public void testReturnMapOne(){
        Map map = uMapper.getReturnMap(3);
        System.out.println(map);
    }

    @Test
    public void testReturnMapMul(){
        List<Map> list = uMapper.getMulMap();
        list.forEach(map -> System.out.println(map));
    }
}
