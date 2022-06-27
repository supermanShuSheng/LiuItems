package com.shusheng.domain.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2021/7/30.
 */
@Data
public class OrgEntity implements Serializable {

    private static final long serialVersionUID = 9178296897481556699L;

    @Excel(name = "事业部分类")
    private String sybfl;

    @Excel(name = "所属上级单位")
    private String org;

    @Excel(name = "上级单位名称")
    private String orgName;

    @Excel(name = "单位名称")
    private String orgNameList;
}
