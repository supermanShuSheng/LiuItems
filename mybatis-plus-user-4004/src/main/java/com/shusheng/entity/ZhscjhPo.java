package com.shusheng.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 综合生产计划管理实体类
 *
 * @Auther 熊兆洪
 * @Date 2021/06/22
 */
@Data
@TableName("LSPMS_ZHSCJH")
public class ZhscjhPo implements Serializable {
    /**
     * 主键
     */
    @TableId
    private String objId;
    /**
     * 编号
     */
    private String zhscjhNo;
    /**
     * 计划标题
     */
    private String jhbt;
    /**
     * 计划分类
     */
    private String jhfl;
    /**
     * 设备状态
     */
    private String sbzt;
    /**
     * 计划编制人
     */
    private String bzr;
    /**
     * 计划编制单位
     */
    private String bzdw;
    /**
     * 计划编制部门
     */
    private String bzbm;
    /**
     * 设备名称
     */
    private String sbmc;
    /**
     * 计划开始日期
     */
    private Date startDate;
    /**
     * 计划结束日期
     */
    private Date endDate;
    /**
     * 计划工期
     */

    private String jhgq;
    /**
     * 工作内容
     */
    private String jhnr;
    /**
     * 备注
     */
    private String bz;

    /**
     * 记录状态
     */
    private String status;
    /**
     * 记录创建时间
     */
    private Date createTime;
    /**
     * 实际完成时间
     */
    private Date sjwcDate;
    /**
     * 指标评价
     */
    private String pjzb;
    /**
     * 计划状态
     */
    private String jhzt;
    /**
     * 计划时间单位
     */
    private String plandurationunit;
    /**
     * 完成状态
     */
    private String completion;
    /**
     * 变电站
     */
    private String subs;
    /**
     * 巡视设备类型
     */
    private String xsSbType;
    /**
     * 巡视内容
     */
    private String xsSubsAll;

    /**
     * 资产单位
     */
    private String assetOrgId;
    /**
     * 运行单位
     */
    private String runOrgId;
    /**
     * 维护检修单位
     */
    private String repairOrgId;
    /**
     * 所属调度单位
     */
    private String dispatchOrgId;
}
