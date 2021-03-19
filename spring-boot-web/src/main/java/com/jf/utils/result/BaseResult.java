package com.jf.utils.result;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.jf.common.meta.ResultCodeEnum;
import com.jf.utils.time.LocalDateTimeUtil;

import lombok.Data;

/**
 * 描述: 返回统一数据结构
 *
 * @author: 江峰
 * @create: 2021-03-19 17:22
 * @since: 2.20.1.1
 */
@Data
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

	/**
	 * 成功返回，无数据
	 */
	public BaseResult() {
		this.setResultCode(ResultCodeEnum.SUCCESS);
		this.setSuccess(Boolean.TRUE);
	}

	/**
	 * 成功返回，有数据
	 * 
	 * @param data
	 */
	public BaseResult(T data) {
		this.data = data;
		this.setSuccess(Boolean.TRUE);
		this.setResultCode(ResultCodeEnum.SUCCESS);
	}

	/**
	 * 成功返回，有数据，自定义code
	 * 
	 * @param data
	 * @param code
	 */
	public BaseResult(T data, Integer code) {
		this(data, code, ResultCodeEnum.SUCCESS.message());
	}

	/**
	 * 成功返回，有数据，自定义msg
	 * 
	 * @param data
	 * @param msg
	 */
	public BaseResult(T data, String msg) {
		this(data, ResultCodeEnum.SUCCESS.code(), msg);
	}

	/**
	 * 成功返回，有数据，自定义code和msg
	 * 
	 * @param data
	 * @param code
	 * @param msg
	 */
	public BaseResult(T data, Integer code, String msg) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.success = Boolean.TRUE;
	}

	private void setResultCode(ResultCodeEnum code) {
		this.code = code.code();
		this.msg = code.message();
	}

	/**
	 * 失败返回,自定义 code和msg
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public BaseResult ofFail(Integer code, String msg) {
		BaseResult result = new BaseResult();
		result.setCode(code);
		result.setMsg(msg);
		result.setSuccess(Boolean.FALSE);
		return result;
	}

	/**
	 * 失败返回,自定义 code
	 * 
	 * @param code
	 * @return
	 */
	public BaseResult ofFail(Integer code) {
		return ofFail(code, ResultCodeEnum.ERROR.message());
	}

	/**
	 * 失败返回,自定义 code
	 * 
	 * @param msg
	 * @return
	 */
	public BaseResult ofFail(String msg) {
		return ofFail(ResultCodeEnum.ERROR.code(), msg);
	}

	public boolean getSuccess() {
		return this.success;
	}

}