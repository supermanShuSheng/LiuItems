package com.shusheng.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
@Data
public class CompleteTaskEntity implements Serializable {

    private static final long serialVersionUID = 2128586570850265619L;

    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 业务实例ID
     */
    private String instanceId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 业务ID
     */
    private String businessKey;
}
