package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 主变相关信息
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class TransformerWindingEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("中文原名")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("绕组类型")
    private String WindingType;

    @CimeNode("厂站标识")
    private String Substation;

    @CimeNode("所属变压器")
    private String PowerTransformer;

    @CimeNode("物理连接节点")
    private String I_node;

    @CimeNode("所属基准电压")
    private String BaseVoltage;

    @CimeNode("所属电压等级")
    private String VoltageLevel;

    @CimeNode("所属间隔标识")
    private String Bay;

    @CimeNode("分接头类型")
    private String TapChangerType;

    @CimeNode("额定功率")
    private String ratedMVA;

    @CimeNode("额定电压")
    private String ratedkV;

    @CimeNode("短路损耗")
    private String loadLoss;

    @CimeNode("短路电压百分值")
    private String leakageImpedence;

    @CimeNode("正序电抗有名值")
    private String x;

    @CimeNode("正序电阻有名值")
    private String r;

    @CimeNode("零序电抗")
    private String x0;

    @CimeNode("零序电阻")
    private String r0;

    @CimeNode("有功上限")
    private String pmax;

    @CimeNode("无功上限")
    private String qmax;

    @CimeNode("有功量测")
    private String P;

    @CimeNode("无功量测")
    private String Q;

    @CimeNode("档位量测")
    private String D;

    @CimeNode("区域id")
    private String Region_id;
}
