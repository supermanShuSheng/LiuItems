package com.shusheng.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
@Data
public class RunFlowEntity implements Serializable {

    private static final long serialVersionUID = 4593915093550734321L;

    /**
     * 实例KEY
     */
    private String defineKey;

    /**
     * 关联业务KEY
     */
    private String businessKey;

    /**
     * 业务数据信息
     */
    private Map<String, Object> dataMap;
}
