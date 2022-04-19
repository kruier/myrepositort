package com.bjpowernode.pojo2;

/**
 *
 */
public class Student {
    private String name;
    private int age;

    //引用类型的成员变量,学生所在的学校
    private School school;

    public Student() {
        System.out.println("学生的无参的构造方法..........");
    }
  //交给Spring容器注入值,必须提供setXXX()方法

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
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
