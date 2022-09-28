package com.jf.mybatis.domain.param;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountCreateParam {
    private Integer id;
    private Integer money;
    private String name;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
