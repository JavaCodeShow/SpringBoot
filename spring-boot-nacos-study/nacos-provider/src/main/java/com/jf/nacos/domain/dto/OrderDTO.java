package com.jf.nacos.domain.dto;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-24 21:21
 * @since: 2.22.1
 */
// @Data
// @Builder
// @AllArgsConstructor
// @NoArgsConstructor
public class OrderDTO {

    private Integer id;

    private String name;

    private String reason;

    public OrderDTO() {
    }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
