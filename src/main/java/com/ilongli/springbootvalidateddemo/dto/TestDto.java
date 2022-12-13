package com.ilongli.springbootvalidateddemo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ilongli
 * @date 2022/12/13 16:19
 */
@Data
public class TestDto {

    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    private Integer age;

}
