package com.shusheng.demo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/5/28.
 */
@Data
public class A implements Serializable {

    private static final long serialVersionUID = -5549009703141025189L;

    @NotBlank(message = "aaa不能为空！")
    private String aaa;
    private String bbb;

    @Valid
    List<C> c;
}
