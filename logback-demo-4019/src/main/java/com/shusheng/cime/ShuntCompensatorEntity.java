package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 电抗器档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class ShuntCompensatorEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("中文原名")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("额定容量")
    private String nomQ;

    @CimeNode("额定电压")
    private String V_rate;

    @CimeNode("物理连接节点")
    private String I_node;

    @CimeNode("所属电压类型")
    private String BaseVoltage;

    @CimeNode("所属电压等级")
    private String VoltageLevel;

    @CimeNode("所属间隔标识")
    private String Bay;

    @CimeNode("厂站标识")
    private String Substation;

    @CimeNode("无功量测")
    private String Q;

    @CimeNode("容抗器类型")
    private String type;

    @CimeNode("区域id")
    private String Region_id;
}
