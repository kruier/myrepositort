package com.bjpowernode.pojo3;

/**
 *
 */
public class School {
    private String name;
    private String address;

    //使用带参构造方法注入值


    public School(String name1, String address1) {
        this.name = name1;
        this.address = address1;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
