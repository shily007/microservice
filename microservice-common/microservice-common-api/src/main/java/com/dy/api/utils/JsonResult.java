package com.dy.api.utils;

import com.dy.api.base.CommonErrorMsg;

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
	
	public JsonResult(CommonErrorMsg errorMsg) {
		super();
		this.success = false;
		this.code = errorMsg.getCode();
		this.msg = errorMsg.getMsg();
	}
	
	public JsonResult(String msg) {
		super();
		this.success = false;
		this.code = 1;
		this.msg = msg;
	}
	
	public JsonResult(T data) {
		super();
		this.data = data;
	}
}
