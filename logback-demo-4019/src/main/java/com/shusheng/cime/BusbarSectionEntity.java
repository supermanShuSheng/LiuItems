package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 母线档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class BusbarSectionEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("名称")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("物理连接节点号")
    private String I_node;

    @CimeNode("所属厂站")
    private String Substation;

    @CimeNode("基准电压标识")
    private String BaseVoltage;

    @CimeNode("所属电压等级")
    private String VoltageLevel;

    @CimeNode("位置信息")
    private String Location;

    @CimeNode("所属间隔标识")
    private String Bay;

    @CimeNode("电压上限")
    private String vmax;

    @CimeNode("电压下限")
    private String vmin;

    @CimeNode("电压量测")
    private String V;

    @CimeNode("相角量测")
    private String A;

    @CimeNode("区域id")
    private String Region_id;
}
