package com.shusheng.excel.complex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/6/17.
 */
@Data
@ExcelTarget("positionEnd")
public class PositionEnd {
    @Excel(name = "终止X")
    private String x;

    @Excel(name = "终止Y")
    private String y;

    @Excel(name = "终止类型")
    private String 类型;

    @Excel(name = "终止名称")
    private String 名称;
}
