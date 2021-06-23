package com.jf.template.domain.dto;

import java.util.List;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述: 接受导入员工标签的excel里面的值
 *
 * @author: 江峰
 * @create: 2021-06-22 16:43
 * @since: 2.27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadStaffTagExcelVo {

	/**
	 * orgId
	 */
	@ExcelProperty("用户所属组织")
	private Integer orgId;

	/**
	 * 账号
	 */
	@ExcelProperty("User ID")
	private String jobNo;

	/**
	 * 员工姓名
	 */

	@ExcelProperty("用户姓名")
	private String name;

	/**
	 * 员工类型id列表
	 */
	@ExcelProperty("用户标签")
	private String categoryIdStr;

	/**
	 * 员工类型id列表
	 */
	private List<Integer> categoryIdList;
}
