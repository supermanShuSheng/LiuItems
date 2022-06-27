package com.shusheng.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
@Data
public class CurveRunEntity implements Serializable {

    private static final long serialVersionUID = 1712046025310024253L;

    /**
     * 当前流程实例ID
     */
    private String instanceId;

}
