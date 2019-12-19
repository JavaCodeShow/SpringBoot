package com.jf.pojo;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   15:26
 */
public class Account {
    /*
    CREATE TABLE `account` (
    `id` int(32) NOT NULL AUTO_INCREMENT,
     `money` double(32,0) DEFAULT NULL,
     PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
     */
    private Integer id;
    private Double money;

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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
