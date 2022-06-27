package com.shusheng.excel.complex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.Data;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/6/17.
 */
@Data
public class WaterGasEntity {
    /**
     * 原水管道
     */
    @ExcelCollection(name = "原水管道")
    private List<YsgdEntity> ysgdEntities;
//    /**
//     * 供水管道
//     */
//    private List<YsgdEntity> gsgdEntities;
}
