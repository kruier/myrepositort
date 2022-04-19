package org.example;

public class Student {
    private int id;
    private String name;
    private int sex;
    private StudentCard studentCard;
    /*省略setter和getter方法*/
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", studentCard=" + studentCard + "]";
    }
}