package com.ilongli.springbootvalidateddemo.common;

/**
 * json返回给前端的状态码基类,返回状态码和对应信息
 * 
 * @author yan
 * @date 2019年3月18日
 */
public class BaseResult {
	private Integer code;
	private String msg;

	public BaseResult() {
		super();
	}

	public BaseResult(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public BaseResult(CodeEnum code) {
		this.code = code.getCode();
		this.msg = code.getMsg();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 成功
	 * 
	 * @return
	 */
	public static BaseResult success() {
		return new BaseResult(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
	}

	/**
	 * 失败
	 * 
	 * @return
	 */
	public static BaseResult error() {
		return new BaseResult(CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMsg());
	}

	@Override
	public String toString() {
		return "BaseResult [code=" + code + ", msg=" + msg + "]";
	}

}
