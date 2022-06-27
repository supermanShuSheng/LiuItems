package com.shusheng.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/8/20.
 */

@Data
public class CarTuo {
    @Excel(name = "原姓名", needMerge = true, width = 20)
    private String yuanName;

    @Excel(name = "脱敏后姓名", needMerge = true, width = 20)
    private String tuoName;

    @Excel(name = "原地址", needMerge = true, width = 20)
    private String yuanAdd;

    @Excel(name = "脱敏后地址", needMerge = true, width = 20)
    private String tuoAdd;
}
