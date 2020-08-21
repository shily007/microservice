package com.dy.provider.config;

/**
 * 返回json对象
 * @author dy
 *
 */

public class JsonResult<T> {
	
	private boolean success = true;
	private int code = 0;
	private String msg;
	private T data;
	
	public JsonResult() {
	}
	
	public JsonResult(int code, String msg) {
		super();
		this.success = false;
		this.code = code;
		this.msg = msg;
	}
	
	public JsonResult(boolean success,String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public JsonResult(int code) {
		super();
		this.code = code;
	}
	
	public JsonResult(String msg) {
		super();
		this.success = false;
		this.msg = msg;
	}
	
	public JsonResult(T data) {
		super();
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
