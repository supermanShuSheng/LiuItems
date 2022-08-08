package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 分接头类型
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class TapChangerTypeEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("名称")
    private String name;

    @CimeNode("额定档位")
    private String neutralStep;

    @CimeNode("中点电压")
    private String neutralKV;

    @CimeNode("最高档位")
    private String highStep;

    @CimeNode("最低档位")
    private String lowStep;

    @CimeNode("步长")
    private String stepVolIncre;
}
