package com.shusheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/6/9.
 */
@Data
@ApiModel(description = "码表查询参数")
public class CodeQueryDto {

    @ApiModelProperty(value = "分页大小", position = 1, example = "10")
    private Integer pageSize;

    @ApiModelProperty(value = "页码", position = 1, example = "1")
    private Integer pageNo;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private String objId;
    /**
     * Value值
     */
    @ApiModelProperty(value = "Value值")
    private String codeValue;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String codeText;
    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private String pobjId;
}
