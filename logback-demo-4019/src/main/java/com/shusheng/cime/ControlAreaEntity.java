package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 区域档案
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class ControlAreaEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("本区域名")
    private String name;

    @CimeNode("父区域名")
    private String Parent;

    @CimeNode("总有功")
    private String p;

    @CimeNode("总无功")
    private String q;

    @CimeNode("区域id")
    private String Region_id;
}
