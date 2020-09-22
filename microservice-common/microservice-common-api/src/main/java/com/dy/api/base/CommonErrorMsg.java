package com.dy.api.base;

/**
 * 
 * 
 * @author dy
 * 2020年9月22日
 */
public enum CommonErrorMsg {
	
	OK(0,"成功！"),
	FAIL(500,"请求错误"),
	SERVICE_CALL_FAILED(100, "服务偷懒了，请稍后再试！");

	private int code;
	private String msg;

	CommonErrorMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
