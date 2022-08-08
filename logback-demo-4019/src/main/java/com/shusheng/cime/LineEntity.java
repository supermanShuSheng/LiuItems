package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 线路中含有交流线路个数
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class LineEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("名称")
    private String name;

    @CimeNode("交流线段个数")
    private String num;
}
