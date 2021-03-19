package com.jf.common.meta;

/**
 * 描述: 状态码
 *
 * @author: 江峰
 * @create: 2021-03-19 18:36
 * @since: 2.20.1.1
 */
public enum ResultCodeEnum {

	// @formatter:off
	
	UNKNOWN_ERROR(404, "未知错误"),
	ERROR(201, "失败"),
	SUCCESS(200, "成功");
	
	// @formatter:on

	private Integer code;

	private String message;

	ResultCodeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer code() {
		return this.code;
	}

	public String message() {
		return this.message;
	}

	public static String getMessage(String name) {
		for (ResultCodeEnum item : ResultCodeEnum.values()) {
			if (item.name().equals(name)) {
				return item.message;
			}
		}
		return name;
	}

	public static Integer getCode(String name) {
		for (ResultCodeEnum item : ResultCodeEnum.values()) {
			if (item.name().equals(name)) {
				return item.code;
			}
		}
		return null;
	}
}