package com.jf.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-01-05 10:31
 * @since: 2.20.1
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "订单实体")
public class OrderDTO {

	@ApiModelProperty(value = "订单主键id")
	private Integer id;

	@ApiModelProperty(value = "订单名字")
	private String name;

	@ApiModelProperty(value = "订单id")
	private Integer orderId;
}
