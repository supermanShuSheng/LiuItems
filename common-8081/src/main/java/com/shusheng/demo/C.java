package com.shusheng.demo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 刘闯
 * @date 2021/8/24.
 */
@Data
public class C {

    @NotBlank(message = "cpo不能为空")
    private String cpo;
}
