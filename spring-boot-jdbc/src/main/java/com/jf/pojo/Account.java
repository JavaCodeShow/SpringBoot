package com.jf.pojo;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   15:26
 */
public class Account {
    private Integer id;
    private Double money;
    private Integer age;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
