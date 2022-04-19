package com.bjpowernode.test;


import com.bjpowernode.pojo2.School;
import com.bjpowernode.pojo2.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class MyTest2 {

    @Test
    public void testStudent(){
       //创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("s02/applicationContext.xml");
        //取出学校对象
        School school = (School) ac.getBean("school");
        System.out.println(school);
    }
    @Test
    public void testStudent2(){
        //创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("s02/applicationContext.xml");
        //取出学校对象
        Student stu = (Student) ac.getBean("stu");
        System.out.println(stu);
    }

}
