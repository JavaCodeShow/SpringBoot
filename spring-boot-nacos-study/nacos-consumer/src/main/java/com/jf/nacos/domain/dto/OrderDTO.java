package com.jf.nacos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-24 21:21
 * @since: 2.22.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Integer id;

    private String name;

    private String reason;
}
