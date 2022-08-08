package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 接地刀闸档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class GroundDisconnectorEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("名称")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("地刀类型")
    private String type;

    @CimeNode("节点1")
    private String I_node;

    @CimeNode("所属厂站")
    private String Substation;

    @CimeNode("所属电压类型")
    private String BaseVoltage;

    @CimeNode("所属电压等级")
    private String VoltageLevel;

    @CimeNode("所属间隔标识")
    private String Bay;

    @CimeNode("接地刀闸状态")
    private String status;

    @CimeNode("区域id")
    private String Region_id;
}
