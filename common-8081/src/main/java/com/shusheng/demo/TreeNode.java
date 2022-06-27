package com.shusheng.demo;

import lombok.Data;

import java.util.List;

/**
 * 构建树节点信息
 * 如果使用 TreeBulidUtils 工具类需要继承该类 否则无法实现
 * @author 刘闯
 * @date 2021/10/27.
 */
@Data
public class TreeNode <T extends TreeNode<T>> {

    /**
     * 本ID
     */
    public String objId;

    /**
     * 父ID
     */
    public String parentId;

    /**
     * 孩子
     */
    public List<T> children;
}
