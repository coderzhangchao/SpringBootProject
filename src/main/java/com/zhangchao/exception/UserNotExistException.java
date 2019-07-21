package com.zhangchao.exception;

public class UserNotExistException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5538561237441478181L;

	public UserNotExistException() {
        super("用户不存在");
    }
}
