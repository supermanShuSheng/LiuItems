package com.shusheng.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/5/21.
 */
@Data
public class Water {
//    @Excel(name = "ID")
//    private String id;

    @Excel(name = "名称")
    private String name;

    @Excel(name = "类型")
    private String type;

    @Excel(name = "X")
    private String x;

    @Excel(name = "Y")
    private String y;
}
