package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 变电站档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class SubstationEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("名称")
    private String name;

    @CimeNode("标准带路径厂站全名")
    private String pathName;

    @CimeNode("厂站类型")
    private String type;

    @CimeNode("所属区域")
    private String ControlArea;

    @CimeNode("最高电压类型")
    private String BaseVoltage;

    @CimeNode("总有功")
    private String P;

    @CimeNode("总无功")
    private String Q;

    @CimeNode("厂站精度")
    private String x;

    @CimeNode("厂站纬度")
    private String y;

    @CimeNode("电流量测标识")
    private String i_flag;

    @CimeNode("地刀量测标识")
    private String mGdis_flag;

    @CimeNode("机组量测标识")
    private String mUnXf_flag;

    @CimeNode("区域id")
    private String Region_id;
}
