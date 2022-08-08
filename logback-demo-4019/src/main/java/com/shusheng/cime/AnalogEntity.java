package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 开关测量值
 * @author 刘闯
 * @date 2022/8/6
 */
@Data
public class AnalogEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("中文原名")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("设备类名")
    private String devName;

    @CimeNode("设备类标识")
    private String devID;

    @CimeNode("量测类型")
    private String type;
}
