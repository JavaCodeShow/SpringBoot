package com.jf.pojo;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   12:49
 */
public class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
