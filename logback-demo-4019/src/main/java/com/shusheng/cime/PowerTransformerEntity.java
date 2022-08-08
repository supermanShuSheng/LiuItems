package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 主类类型与空载
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class PowerTransformerEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("中文原名")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("变压器类型")
    private String type;

    @CimeNode("所属厂站")
    private String Substation;

    @CimeNode("空载损耗(KW)")
    private String NoLoadLoss;

    @CimeNode("空载电流百分值")
    private String ExcitingCurrent;

    @CimeNode("区域id")
    private String Region_id;
}
