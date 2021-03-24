package com.jf.css.common.meta;

import com.jf.common.utils.common.meta.BaseResponseInfoInterface;
import com.jf.css.common.constant.CommonConstant;

import lombok.Getter;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-03-20 22:15:46
 * @since
 */
@Getter
public enum ErrorCodeMeta implements BaseResponseInfoInterface {
	// @formatter:off

    COUPON_ERROR(CommonConstant.SYSTEM_CODE + "-" + "10000", "优惠券兑换错误");

    // @formatter:on

	private String code;

	private String message;

	ErrorCodeMeta(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 根据code获取该code对应的枚举
	 *
	 * @param code
	 * @return
	 */
	public static ErrorCodeMeta getEnumByCode(String code) {
		for (ErrorCodeMeta item : ErrorCodeMeta.values()) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * 根据code获取该code对应的枚举的描述
	 *
	 * @param code
	 * @return
	 */
	public static String getMessageByCode(String code) {
		for (ErrorCodeMeta item : ErrorCodeMeta.values()) {
			if (item.getCode().equals(code)) {
				return item.message;
			}
		}
		return null;
	}

	/**
	 * 根据描述获取对应的枚举
	 *
	 * @param msg
	 * @return
	 */
	public static ErrorCodeMeta getEnumByMessage(String msg) {
		for (ErrorCodeMeta item : ErrorCodeMeta.values()) {
			if (item.getMessage().equals(msg)) {
				return item;
			}
		}
		return null;
	}
}