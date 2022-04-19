package org.example;

import org.junit.Before;
import org.junit.Test;
import org.niub.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testt {
    ApplicationContext ac;
    @Before
    public void getAc(){

        ac=new ClassPathXmlApplicationContext("file:C:/Users/18134/Desktop/bok/04_project/04_project/mybatisall/spring/src/applicationContext.xml");
    }
    @Test
    public void test(){


        Student student = (Student) ac.getBean("stu");
        System .out.println(student) ;
    }
}
