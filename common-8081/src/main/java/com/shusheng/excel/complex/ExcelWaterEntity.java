package com.shusheng.excel.complex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/6/17.
 */
@Data
public class ExcelWaterEntity {
    @Excel(name = "线段ID")
    private String 线段ID;

    @Excel(name = "线段名称")
    private String 线段名称;

    @Excel(name = "管径")
    private String 管径;

    @ExcelEntity(id = "positionSta", name = "起始")
    private PositionSta 起始;

    @ExcelEntity(id = "positionEnd", name = "终止")
    private PositionEnd 终止;
}
