package com.ilongli.springbootvalidateddemo.common;

public enum CodeEnum {
	SUCCESS(200,"成功"),
	ERROR(500,"失败"),
	NOTFIND(404,"请求失败"),
	PARAM_ERROR(1010,"参数错误");

	private int code;
	private String msg;
	private CodeEnum(int code,String msg) {
		this.code = code;
		this.msg = msg;
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
}
