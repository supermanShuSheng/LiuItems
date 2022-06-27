package com.shusheng.excel.complex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/6/17.
 */
@Data
@ExcelTarget("positionSta")
public class PositionSta {
    @Excel(name = "起始X")
    private String x;

    @Excel(name = "起始Y")
    private String y;

    @Excel(name = "起始类型")
    private String 类型;

    @Excel(name = "起始名称")
    private String 名称;
}
