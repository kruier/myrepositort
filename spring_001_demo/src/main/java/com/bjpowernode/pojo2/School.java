package com.bjpowernode.pojo2;

/**
 *
 */
public class School {
    private String name;
    private String address;

    //为了给成员变量注入值,必须提供无参构造方法和setXXX()方法


    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School() {
        System.out.println("学校的无参的构造方法被调用..........");
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
