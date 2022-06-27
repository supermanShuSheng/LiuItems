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
@ExcelTarget("tpEntity")
public class TpEntity {
    /**
     * 节点名称
     */
    @Excel(name = "节点名称")
    private String jdName;
    /**
     * 节点类型
     */
    @Excel(name = "节点类型")
    private String jdType;
    /**
     * 经纬度
     */
    @ExcelCollection(name = "经纬度")
    private List<JwdEntity> jwdEntityList;
}
