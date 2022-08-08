package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 各类设备档案信息
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class EndDeviceEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("名称")
    private String name;

    @CimeNode("别名")
    private String pathName;

    @CimeNode("所属电压类型")
    private String BaseVoltage;

    @CimeNode("物理连接节点号")
    private String I_node;

    @CimeNode("所属电压等级")
    private String VoltageLevel;

    @CimeNode("所属厂站")
    private String Substation;
}
