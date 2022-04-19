package com.bjpowernode.test;

import com.bjpowernode.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class MyTest1 {

    @Test
    public void testStudent(){
        //程序员创建对象
//        Student stu = new Student();
//        System.out.println(stu);
    }
//C:\Users\18134\Desktop\bok\spring\04_project\04_project\springall\spring_001_demo\src\main\resources\s01\applicationContext.xml
    @Test
    public void testStudentSprng(){
        //由spring容器进行对象的创建

        //如果想从spring容器中取出对象,则要先创建容器对象,并启动才可以取对象.
        ApplicationContext ac = new ClassPathXmlApplicationContext("s01/applicationContext.xml");
        //取出对象
        Student stu = (Student) ac.getBean("stu");
        System.out.println(stu);
    }
}
