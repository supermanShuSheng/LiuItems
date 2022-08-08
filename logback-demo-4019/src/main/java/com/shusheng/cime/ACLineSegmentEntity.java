package com.shusheng.cime;

import com.shusheng.commons.CimeNode;
import lombok.Data;

/**
 * 线路连接点
 * @author 刘闯
 * @date 2022/8/8
 */
@Data
public class ACLineSegmentEntity {

    @CimeNode("序号")
    private String Num;

    @CimeNode("标识")
    private String mRID;

    @CimeNode("名称")
    private String name;

    @CimeNode("标准带路径全名")
    private String pathName;

    @CimeNode("首端厂站标识")
    private String StartSt;

    @CimeNode("末端厂站标识")
    private String EndSt;

    @CimeNode("功率限制")
    private String ratedMW;

    @CimeNode("允许载流量")
    private String ratedCurrent;

    @CimeNode("所属基准电压")
    private String BaseVoltage;

    @CimeNode("正序电阻有名值")
    private String r;

    @CimeNode("正序电抗有名值")
    private String x;

    @CimeNode("正序电纳有名值")
    private String bch;

    @CimeNode("零序电阻有名值")
    private String r0;

    @CimeNode("零序电抗有名值")
    private String x0;

    @CimeNode("零序电纳有名值")
    private String b0ch;

    @CimeNode("交流线段等值标志")
    private String eqflag;

    @CimeNode("区域id")
    private String Region_id;
}
