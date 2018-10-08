package com.jf.pojo;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   12:56
 */
public class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
