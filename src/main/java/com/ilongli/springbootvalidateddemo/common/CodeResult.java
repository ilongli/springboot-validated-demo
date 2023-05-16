package com.ilongli.springbootvalidateddemo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * json返回给前端的状态码
 * 
 * @author yan
 * @date 2019年3月18日
 */
public class CodeResult extends BaseResult {

	private static final Logger logger = LoggerFactory.getLogger(CodeResult.class);

	private Object data;

	public CodeResult() {
		super();
		data = new HashMap<String, Object>();
	}

	public CodeResult(CodeEnum code, Object data) {
		super(code);
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		this.data = data;
	}

	public CodeResult(Integer code, String msg) {
		super(code, msg);
		this.data = null;
	}

	public CodeResult(Integer code, String msg, Object data) {
		super(code, msg);
		if (data == null) {
			data = new HashMap<String, Object>();
		}
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 成功
	 */
	public static CodeResult success() {
		return new CodeResult(CodeEnum.SUCCESS, null);
	}

	/**
	 * 成功
	 * 
	 * @param data
	 * @return
	 */
	public static CodeResult success(Object data) {
		return new CodeResult(CodeEnum.SUCCESS, data);
	}

	/**
	 * 失败
	 */
	public static CodeResult error() {
		return new CodeResult(CodeEnum.ERROR, null);
	}

	/**
	 * 失败
	 * 
	 * @param data
	 * @return
	 */
	public static CodeResult error(Object data) {
		return new CodeResult(CodeEnum.ERROR, data);
	}

	@Override
	public String toString() {
		return super.toString() + "[data=" + data + "]";
	}

	/**
	 * 根据布尔值返回result
	 * @author ilongli
	 */
	public static CodeResult judge(boolean isSuccess, String errorMsg) {
		return isSuccess ? new CodeResult(CodeEnum.SUCCESS, null) : new CodeResult(CodeEnum.ERROR, errorMsg);
	}
	public static CodeResult judge(boolean isSuccess) {
		return judge(isSuccess, null);
	}


	public boolean judgeSuccess() {
		return this.getCode().equals(CodeEnum.SUCCESS.getCode());
	}
}
