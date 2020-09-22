package com.dy.shop.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 返回json对象
 * @author dy
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class JsonResult<T> {
	
	private boolean success = true;
	private int code = 0;
	private String msg;
	private T data;
	
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
}
