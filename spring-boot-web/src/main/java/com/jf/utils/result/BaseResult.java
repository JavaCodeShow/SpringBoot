package com.jf.utils.result;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.jf.utils.time.LocalDateTimeUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 描述: 返回统一数据结构
 *
 * @author: 江峰
 * @create: 2021-03-19 17:22
 * @since: 2.20.1.1
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> implements Serializable {

	/**
	 * 是否成功
	 */
	private Boolean success;

	/**
	 * 服务器当前时间
	 */
	private String time = LocalDateTimeUtil
			.getLocalDateTimeStr(LocalDateTime.now());

	/**
	 * 成功数据
	 */
	private T data;

	/**
	 * 错误码
	 */
	private Integer code;

	/**
	 * 错误描述
	 */
	private String msg;

	public boolean getSuccess() {
		return this.success;
	}

	public BaseResult<T> ofSuccess(T data) {
		BaseResult baseResult = new BaseResult();
		baseResult.success = true;
		baseResult.setCode(200);
		baseResult.setData(data);
		return baseResult;
	}

	public BaseResult ofFail(Integer code, String msg) {
		BaseResult baseResult = new BaseResult();
		baseResult.success = false;
		baseResult.code = code;
		baseResult.msg = msg;
		return baseResult;
	}

	public BaseResult<T> ofFail(T data, Integer code, String msg) {
		BaseResult baseResult = new BaseResult();
		baseResult.success = false;
		baseResult.code = code;
		baseResult.msg = msg;
		baseResult.setData(data);
		return baseResult;
	}
}