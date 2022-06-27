package com.shusheng.domain.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 刘闯
 * @date 2021/3/19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "新增用户")
public class UserInsertDto {

    /**
     * @Setter 自己重写set放马
     */
    @ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "id不能为空！")
    @Min(value = 5)
    private Integer id;

    @ApiModelProperty(value = "用户名称", required = true)
    @NotBlank(message = "名称不能为空！")
    @Min(5)
    private String name;

    @ApiModelProperty("用户年龄")
    private Integer age;

    // 比当前日期晚
    @Future
    private Date createDate;

    /**
     * @DateTimeFormat 接收前端的String 自动转成Date
     * @JsonFormat 从数据库查出来后  自动将Date日期转成String
     */
    @DateTimeFormat
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;
}
