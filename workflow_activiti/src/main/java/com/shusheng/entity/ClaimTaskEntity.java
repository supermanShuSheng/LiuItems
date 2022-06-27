package com.shusheng.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
@Data
public class ClaimTaskEntity implements Serializable {

    private static final long serialVersionUID = -8878736913527508383L;

    /**
     * 当前流程实例ID
     */
    private String instanceId;
}
