package com.shusheng.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘闯
 * @date 2021/4/1.
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiuVo {
    @Excel(name = "Ctnb", needMerge = true, width = 20)
    private String ctnb;

    @Excel(name = "Ctn", needMerge = true, width = 20)
    private String ctn;

    @Excel(name = "Date", needMerge = true, width = 20)
    private String date;

    @Excel(name = "24hPM25avg", needMerge = true, width = 20)
    private Double pm;
}
