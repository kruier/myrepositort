package org.niub;

public class  Student{
    private String name;
    private int age;
    //无参构造方法是为spring提供创建对象 这个是必须的
    public Student() {
        System.out.println("我是学生类的无参构造方法");
    }
    //setXXX方法是为spring提供进行赋值操作的   也是必须的
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
//    习惯问题 大概吧....
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}