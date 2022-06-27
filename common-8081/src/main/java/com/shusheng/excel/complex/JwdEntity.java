package com.shusheng.excel.complex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/6/17.
 */
@Data
@ExcelTarget("jwdEntity")
public class JwdEntity {
    /**
     * 横坐标
     */
    @Excel(name = "横坐标")
    private String x;

    /**
     * 纵坐标
     */
    @Excel(name = "纵坐标")
    private String y;
}
