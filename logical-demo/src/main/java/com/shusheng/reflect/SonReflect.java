package com.shusheng.reflect;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/7/19.
 */
@Data
public class SonReflect {

    /**
     * 分页大小
     **/
    @ApiModelProperty(value = "分页大小", position = -1, example = "10")
    private Integer pageSize;
    /**
     * 分页页码
     **/
    @ApiModelProperty(value = "页码", position = -1, example = "1")
    private Integer pageNo;
}
