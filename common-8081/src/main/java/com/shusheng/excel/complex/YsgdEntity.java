package com.shusheng.excel.complex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/6/17.
 */
@Data
@ExcelTarget("ysgdEntity")
public class YsgdEntity {
    /**
     * 管道ID
     */
    @Excel(name = "管道ID", needMerge = true, mergeVertical = true)
    private String gdId;
    /**
     * 管道名称
     */
    @Excel(name = "名称", needMerge = true, mergeVertical = true)
    private String gdName;
    /**
     * 拓扑
     */
    @ExcelCollection(name = "拓扑")
    private List<TpEntity> tpEntities;
}
