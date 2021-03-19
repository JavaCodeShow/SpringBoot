package com.jf.config.exception;

/**
 * @author 潇潇暮雨
 * @create 2018-09-30 20:45
 */

public class UserNotExitException extends RuntimeException {

	public UserNotExitException(String message) {
		super(message);
	}

}
