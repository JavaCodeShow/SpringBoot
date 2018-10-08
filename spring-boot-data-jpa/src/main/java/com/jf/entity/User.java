package com.jf.entity;

import javax.persistence.*;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   18:24
 */
// 使用jpa注解配置映射关系
@Entity // 告诉jpa这是一个实体类（和数据库进行映射的类）
@Table // 告诉数据表和那个数据表进行映射，如果省略，那么表明默认就是user。
public class User {

    @Id // 主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自增主键
    private Integer id;

    @Column(name = "user_name",length = 50) // 设置表名和表的长度，如果省略，那么数据表中默认就是改字段的名字，长度为255。
    private String name;

    @Column
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
