package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 主变档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class BayEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("名称")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("所属厂站")
    private String Substation;

    @CimeNode("所属电压等级")
    private String VoltageLevel;

    @CimeNode("所属电压类型")
    private String BaseVoltage;

    @CimeNode("结线类型")
    private String type;

    @CimeNode("区域id")
    private String Region_id;
}
