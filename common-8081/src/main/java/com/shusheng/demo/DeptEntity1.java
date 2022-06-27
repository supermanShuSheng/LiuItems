package com.shusheng.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 刘闯
 * @date 2021/10/27.
 */
@Data
@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class DeptEntity1 extends TreeNode<DeptEntity1> {
    /**
     * 名称
     */
    private String deptName;

    @Override
    public String toString() {
        return "DeptEntity{" +
                "deptName='" + deptName + '\'' +
                ", objId='" + objId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", children=" + children +
                '}';
    }
}
