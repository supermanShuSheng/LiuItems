package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 线路档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class ACLineDotEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("名称")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("交流线段标识")
    private String ACLineSegment;

    @CimeNode("厂站标识")
    private String Substation;

    @CimeNode("物理连接节点")
    private String I_node;

    @CimeNode("基准电压标识")
    private String BaseVoltage;

    @CimeNode("电压等级标识")
    private String VoltageLevel;

    @CimeNode("所属间隔标识")
    private String Bay;

    @CimeNode("有功量测")
    private String P;

    @CimeNode("无功量测")
    private String Q;

    @CimeNode("电流量测")
    private String I;

    @CimeNode("区域id")
    private String Region_id;
}
