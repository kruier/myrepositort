package com.bjpowernode.test;

import com.bjpowernode.mapper.BookMapper;
import com.bjpowernode.mapper.CustomerMapper;
import com.bjpowernode.mapper.OrdersMapper;
import com.bjpowernode.pojo.Book;
import com.bjpowernode.pojo.Customer;
import com.bjpowernode.pojo.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 */
public class MyTest {
    SqlSession sqlSession;
    BookMapper bookMapper;
    CustomerMapper customerMapper;
    OrdersMapper ordersMapper;


    @Before  //在所有的@Test方法执行前先执行的代码
    public void openSqlSession() throws IOException {
        //使用文件流读取核心配置文件SqlMapConfig.xml
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //取出sqlSession的对象
        sqlSession = factory.openSession();
        bookMapper = sqlSession.getMapper(BookMapper.class);
        customerMapper = sqlSession.getMapper(CustomerMapper.class);
        ordersMapper = sqlSession.getMapper(OrdersMapper.class);
    }

    @After
    public void closeSqlSession(){
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetAll(){
        List<Book> list = bookMapper.getAll();
        list.forEach(book -> System.out.println(book));
    }

    @Test
    public void testGetCustomerById(){
        Customer customer = customerMapper.getById(3);
        System.out.println(customer);

    }
    @Test
    public void testGetOrdersById(){
        Orders orders = ordersMapper.getById(11);
        System.out.println(orders);

    }
}
