package com.shusheng.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/3/26.
 */

@Data
public class LiuDto {
    @Excel(name = "Ctnb")
    private String ctnb;

    @Excel(name = "Ctn")
    private String ctn;

    @Excel(name = "Prvn")
    private String prvn;

    @Excel(name = "Date")
    private String date;

    @Excel(name = "Qltlv")
    private String qltlv;

    @Excel(name = "24hPM25avg")
    private Double pm;
}
