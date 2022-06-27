package com.shusheng.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/7/12.
 */
public class JSR303Demo {

    @NotBlank // 不能为空
    @Size(max = 6, message = "") // 校验长度
    private String name;

    //  最小值  最大值
    @Min(18)  // 大于等于18
    @Max(22)
    private Integer age;

    @Past // 日期类型比当前时间早
    private Date date;

    @Future // 日期类型比当前晚
    private Date dateAfter;

    @Length(min = 18, max = 22)  // 相当于一个Min一个Max
    private String nameLength;

    @Email // 是一个邮箱
    private String email;

    @Range(min = 18, max = 22)
    private Integer ageLength;

    @Pattern(regexp = "")  // 使用正则表达式进行校验
    private String pattern;

    @Size(min = 2,message = "必须选择两个以上的爱好")
    private List<String> favorites;

    @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",message = "手机号码不合法")
    private String phone;
}

