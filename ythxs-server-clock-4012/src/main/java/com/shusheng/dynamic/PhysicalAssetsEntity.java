package com.shusheng.dynamic;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 李权
 * @Date 2021/08/12
 */

@Data
@ApiModel(description = "资产设备实体")
public class PhysicalAssetsEntity implements Serializable {
    private static final long serialVersionUID = 8945211838468465677L;

    /**
     * 变电站/线路
     */
    @ApiModelProperty(value = "变电站/线路", position = 0)
    private String subsId;
    /**
     * 设备ID
     */
    @ApiModelProperty(value = "设备ID", position = 1)
    private String equipId;
    /**
     * 设备编号
     */
    @ApiModelProperty(value = "设备编号", position = 2)
    private String equipNo;
    /**
     *设备名称
     */
    @ApiModelProperty(value = "设备名称", position = 3)
    private String equipName;
    /**
     * 资产单位id
     */
    @ApiModelProperty(value = "资产单位id", position = 4)
    private String orgId;
    /**
     * 资产来源
     */
    @ApiModelProperty(value = "资产来源", position = 5)
    private String assSource;
    /**
     * 投运日期
     */
    @DateTimeFormat
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "投运日期", position = 6)
    private Date runData;
    /**
     * 维护检修单位
     */
    @ApiModelProperty(value = "维护检修单位", position = 7)
    private String repairOrgId;
    /**
     * 运行单位
     */
    @ApiModelProperty(value = "运行单位", position = 8)
    private String runOrgId;
    /**
     * 存放地点
     */
    @ApiModelProperty(value = "存放地点", position = 9)
    private String storeLocation;
    /**
     * 设备主人
     */
    @ApiModelProperty(value = "设备主人", position = 10)
    private String equipOwner;
    /**
     * 表名称
     */
    @ApiModelProperty(value = "表名称", position = 10)
    private String tableName;

    /**
     * 设备字段ID
     */
    @ApiModelProperty(value = "设备字段ID", position = 1)
    private String equipFieldId;
}
