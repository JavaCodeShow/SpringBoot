package com.jf.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Employee {

    private Integer id;

    @NotNull(message = "不能为空")
    @NotBlank(message = "不能为空")
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
    private Department department;
    private Date birth;
}
