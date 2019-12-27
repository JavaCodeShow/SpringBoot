package com.jf.mybatis.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author 江峰
 * @create 2019-12-27   15:45
 */
@Data
public class Classes {
    private int id;
    private String name;
    private Teacher teacher;
    private List<Student> studentList;
}