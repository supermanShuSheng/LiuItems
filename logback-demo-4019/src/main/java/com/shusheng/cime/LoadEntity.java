package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 负荷档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class LoadEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("中文原名")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("所属厂站标识")
    private String Substation;

    @CimeNode("物理连接节点号")
    private String I_node;

    @CimeNode("基准电压标识")
    private String BaseVoltage;

    @CimeNode("所属电压等级")
    private String VoltageLevel;

    @CimeNode("所属间隔标识")
    private String Bay;

    @CimeNode("有功")
    private String P;

    @CimeNode("无功")
    private String Q;

    @CimeNode("区域id")
    private String Region_id;
}
