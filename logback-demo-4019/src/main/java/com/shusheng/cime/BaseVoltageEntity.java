package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 电压等级
 * @author 刘闯
 * @date 2022/8/6
 */
@Data
public class BaseVoltageEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("基准电压名")
    private String name;

    @CimeNode("基准电压")
    private String nomkV;

    @CimeNode("区域id")
    private String Region_id;
}
