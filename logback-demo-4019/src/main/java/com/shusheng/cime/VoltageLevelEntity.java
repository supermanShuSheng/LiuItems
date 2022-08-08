package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 站电压类型
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class VoltageLevelEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("中文原名")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("电压上限")
    private String highkV;

    @CimeNode("电压下限")
    private String lowkV    ;

    @CimeNode("所属厂站")
    private String Substation;

    @CimeNode("所属基准电压")
    private String BaseVoltage;

    @CimeNode("接线类型")
    private String type;

    @CimeNode("区域id")
    private String Region_id;
}
