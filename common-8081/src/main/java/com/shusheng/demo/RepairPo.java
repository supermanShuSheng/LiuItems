package com.shusheng.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 检修计划实体类
 *
 * @author 刘闯
 * @since 2021-03-24 14:44:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairPo implements Serializable {
    private static final long serialVersionUID = -89736021028601465L;
    /**
    * 检修计划_ID
    */
    private String jxjhId;
    /**
    * 检修计划编号
    */
    private String jxjhNo;
    /**
    * 检修单位
    */
    private String org;
    /**
    * 检修计划名称
    */
    private String name;
    /**
    * 检修计划类型
    */
    private String kind;
    /**
    * 检修性质
    */
    private String type;
    /**
    * 检修计划时间
    */
    private String createTime;
    /**
    * 变电站/线路名称
    */
    private String subLine;
    /**
    * 主网/配网
    */
    private String mainSubNet;
    /**
    * 预计开工时间
    */
    private String beginTime;
    /**
    * 预计结束时间
    */
    private String endTime;
    /**
    * 停电设备及停电范围
    */
    private String range;
    /**
    * 检修内容
    */
    private String content;
    /**
    * 是否作废
    */
    private String isInvalid;
    /**
    * 作废原因
    */
    private String invalidReason;
    /**
    * 审核状态
    */
    private String checkStatus;
    /**
    * 批复意见
    */
    private String checkOpinion;
    /**
    * 备注(可不用)
    */
    private String remark;
}
