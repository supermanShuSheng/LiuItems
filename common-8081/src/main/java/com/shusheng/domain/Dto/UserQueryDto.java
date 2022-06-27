package com.shusheng.domain.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author 刘闯
 * @date 2021/3/19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "查询用户")
public class UserQueryDto {

    @ApiModelProperty("用户id")
    private int id;
    @ApiModelProperty("用户名称")
    private String name;
}
