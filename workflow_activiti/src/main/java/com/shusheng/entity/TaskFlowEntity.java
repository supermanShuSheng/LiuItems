package com.shusheng.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
@Data
public class TaskFlowEntity implements Serializable {
    private static final long serialVersionUID = -1778513226252522060L;

    /**
     * 实例KEY
     */
    private String defineKey;

    /**
     * 某个实体ID
     */
    private String instanceId;

    /**
     * 关联业务KEY
     */
    private String businessKey;

    /**
     * 人员信息
     */
    private String assignee;
}
