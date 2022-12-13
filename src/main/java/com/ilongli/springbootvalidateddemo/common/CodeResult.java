package com.ilongli.springbootvalidateddemo.common;

import lombok.Data;

/**
 * @author ilongli
 * @date 2022/12/13 15:39
 */
@Data
public class CodeResult {

    {
        code = 200;
        msg = "成功";
    }

    private Integer code;

    private String msg;

    private String data;

    public static CodeResult error(String msg) {

        CodeResult res = new CodeResult();
        res.setCode(405);
        res.setMsg(msg);

        return res;
    }

}
