package com.shusheng.domain.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2021/7/30.
 */
@Data
public class DeptEntity implements Serializable {

    private static final long serialVersionUID = 9178296897481556699L;

    @Excel(name = "单位名称")
    private String orgName;

    @Excel(name = "父部门")
    private String deptMame;
}
