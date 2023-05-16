package com.ilongli.springbootvalidateddemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ilongli
 * @date 2023/5/16 15:54
 */
@Data
@AllArgsConstructor
public class ValidatedErrorVo {

    private String field;

    private Object value;

    private String message;

}
