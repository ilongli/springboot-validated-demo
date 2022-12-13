package com.ilongli.springbootvalidateddemo.controller;

import com.ilongli.springbootvalidateddemo.common.CodeResult;
import com.ilongli.springbootvalidateddemo.dto.TestDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author ilongli
 * @date 2022/12/13 15:38
 */
@RestController
@RequestMapping("")
@Validated
public class IndexController {


    @GetMapping("test1")
    public CodeResult test1(
            @NotNull(message = "名称不能为空") String name,
            @NotNull(message = "年龄不能为空") Integer age
    ) {
        CodeResult res = new CodeResult();
        res.setData(name);
        return res;
    }


    @GetMapping("test2")
    public CodeResult test2(@Validated TestDto dto) {
        CodeResult res = new CodeResult();
        res.setData(dto.toString());
        return res;
    }


    @PostMapping("test3")
    public CodeResult test3(@Validated @RequestBody TestDto dto) {
        CodeResult res = new CodeResult();
        res.setData(dto.toString());
        return res;
    }

}
