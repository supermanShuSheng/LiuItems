package com.shusheng.demo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author 刘闯
 * @since 2021-03-24 14:44:59
 */
@Data
public class RepairSummaryVo implements Serializable {
    private static final long serialVersionUID = 326474078990428133L;

    /**
    * 主网/配网
    */
    private String mainSubNet;
    /**
    * 标题
    */
    private String title;
    /**
     * 报表日期
     */
    private String reportDate;
    /**
     * 汇总人
     */
    private String summaryName;
    /**
     * 汇总日期
     */
    private String summaryDate;

}
