package com.shusheng.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 刘闯
 * @date 2021/3/30.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "测试")

@JsonInclude(value= JsonInclude.Include.NON_NULL)  // 如果里面有字段未空值 则不返回该字段

public class TestDemo {

    /**
     * @Setter 自己重写set放马
     */
    @ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "id不能为空！")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @ApiModelProperty(value = "用户名称", required = true)
    @NotBlank(message = "名称不能为空！")
    private String name;

    @ApiModelProperty("用户年龄")
    private Integer age;

    /**
     * @DateTimeFormat 接收前端的String 自动转成Date
     * @JsonFormat 从数据库查出来后  自动将Date日期转成String
     */
    @DateTimeFormat
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @NotNull(message = "")
    private Date date;
}
