package com.bjpowernode.pojo3;

import org.springframework.stereotype.Component;

@Component("mystudent")
public class Student {

    private String name;
    private int age;

    //引用类型的成员变量
    private School school;


















    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
