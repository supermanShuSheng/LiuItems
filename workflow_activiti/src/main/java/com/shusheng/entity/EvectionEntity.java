package com.shusheng.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
@Data
public class EvectionEntity implements Serializable {

    private static final long serialVersionUID = 1237678136447884569L;

    /**
     * 数量
     */
    private Double num;
}
