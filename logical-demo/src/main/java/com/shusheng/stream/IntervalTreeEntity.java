package com.shusheng.stream;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author 刘闯
 * @date 2021/7/22.
 */
@Data
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
public class IntervalTreeEntity {

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
    /**
     * 查询信息条件
     */
    private String equipType;
    /**
     * 分组数据
     */
    private Map<String, List<IntervalTreeEntity>> groupUnit;
}
