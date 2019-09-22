package com.jf.bean;

/**
 * @author 潇潇暮雨
 * @create 2019-09-16   14:31
 */
public class Car {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
