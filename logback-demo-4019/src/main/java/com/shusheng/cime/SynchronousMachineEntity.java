package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 发动机档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class SynchronousMachineEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("中文原名")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("发电机类型")
    private String type;

    @CimeNode("物理连接节点号")
    private String I_node;

    @CimeNode("所属厂站")
    private String Substation;

    @CimeNode("所属电压类型")
    private String BaseVoltage;

    @CimeNode("所属电压等级")
    private String VoltageLevel;

    @CimeNode("额定容量")
    private String RatedMW;

    @CimeNode("额定电压")
    private String kvnom;

    @CimeNode("电压上限")
    private String maxU;

    @CimeNode("电压下限")
    private String minU;

    @CimeNode("机组无功上限")
    private String maxQ;

    @CimeNode("机组无功下限")
    private String minQ;

    @CimeNode("机组有功上限")
    private String maxP;

    @CimeNode("机组有功下限")
    private String minP;

    @CimeNode("正序电阻")
    private String r;

    @CimeNode("正序电抗")
    private String x;

    @CimeNode("零序电阻")
    private String r0;

    @CimeNode("零序电抗")
    private String x0;

    @CimeNode("厂用电率")
    private String AuxRatio;

    @CimeNode("有功")
    private String P;

    @CimeNode("无功")
    private String Q;

    @CimeNode("机端电压")
    private String V;

    @CimeNode("区域id")
    private String Region_id;
}
