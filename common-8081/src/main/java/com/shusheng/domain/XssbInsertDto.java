package com.shusheng.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 巡视设备列表实体类
 *
 * @author 刘闯
 * @since 2021-05-28 09:48:11
 */
@Data
@ApiModel(description = "巡视设备列表新增参数")
public class XssbInsertDto implements Serializable {
    private static final long serialVersionUID = 309122233710043037L;

    /**
    * 设备ID
    */
    @ApiModelProperty(value = "设备ID", position = 3, example = "设备ID")
    private String equipId;
    /**
    * 设备类型
    */
    @ApiModelProperty(value = "设备类型", position = 4, example = "设备类型")
    private String equipType;
    /**
    * 设备名称
    */
    @ApiModelProperty(value = "设备名称", position = 5, example = "设备名称")
    private String equipName;
}
