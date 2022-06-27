package com.shusheng.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
@Data
public class RepositoryFlowEntity implements Serializable {
    private static final long serialVersionUID = -5489511988949703338L;

    /**
     * 静态资源ID
     */
    private String bytearrayId;

    /**
     * 静态资源路径
     */
    private String resourceBytes;

    /**
     * 实例名称
     */
    private String name;

    /**
     * 路径
     */
    private List<String> resourcePaths;
}
