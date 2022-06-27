package com.shusheng.stream;

import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/7/22.
 */
@Data
public class UnitTreeEntity {
    /**
     * 发电站ID
     */
    private String subsId;
    /**
     * 主键ID
     */
    private String objId;
    /**
     * 主键名称
     */
    private String objName;
    /**
     * 所属间隔单元
     */
    private String intervalUnit;
    /**
     * 所属类型名称
     */
    private String typeName;
}
