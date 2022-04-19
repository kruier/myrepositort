package com.bjpowernode.test;

import com.bjpowernode.pojo3.School;
import com.bjpowernode.pojo3.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class MyTest3 {

   @Test
    public void testSchool(){
       ApplicationContext ac = new ClassPathXmlApplicationContext("s03/applicationContext.xml");
       School school = (School) ac.getBean("school");
       System.out.println(school);
   }
    @Test
    public void testStudent(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("s03/applicationContext.xml");
       Student stude = (Student) ac.getBean("student");
        System.out.println("112");
        System.out.println(stude);
    }
    @Test
    public void testStudentSequence(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("s03/applicationContext.xml");
        Student stu = (Student) ac.getBean("stuSequence");
        System.out.println(stu);
    }

}
