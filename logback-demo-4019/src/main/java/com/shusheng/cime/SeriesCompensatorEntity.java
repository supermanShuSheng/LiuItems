package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * KVPT档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class SeriesCompensatorEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("中文名称")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("电阻")
    private String r;

    @CimeNode("电抗")
    private String x;

    @CimeNode("首端连接点号")
    private String I_node;

    @CimeNode("末端连接点号")
    private String J_node;

    @CimeNode("所属电压类型")
    private String BaseVoltage;

    @CimeNode("电压等级")
    private String VoltageLevel;

    @CimeNode("所属间隔标识")
    private String Bay;

    @CimeNode("所属厂站")
    private String Substation;

    @CimeNode("I侧有功")
    private String Pi;

    @CimeNode("I侧无功")
    private String Qi;

    @CimeNode("J侧有功")
    private String Pj;

    @CimeNode("J侧无功")
    private String Qj;

    @CimeNode("容抗器类型")
    private String type;

    @CimeNode("区域id")
    private String Region_id;
}
