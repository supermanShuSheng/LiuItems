package com.shusheng.domain.Vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2021/3/19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryVo implements Serializable {
    private static final long serialVersionUID = 883941780873274676L;

    @ApiModelProperty("用户id")
    private int id;
    @ApiModelProperty("用户年龄")
    private int age;
}
