package com.shusheng.utils;

import cn.hutool.core.util.ReflectUtil;
import com.shusheng.demo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 构建树
 * @author 刘闯
 * @date 2021/10/27.
 */
public class TreeBulidUtils {

    /**
     * 构建递归树
     * @param dates 数据源
     * @param parentId  根路径ID
     * @return
     */
    public static <T extends TreeNode<T>> List<T> createTree(List<T> dates, String parentId){
        List<T> resultTree = new ArrayList<>();
        for (T date : dates) {
            if (date.getParentId().equals(parentId)) {
                // 设置孩子值
                date.setChildren(createTree(dates, date.getObjId()));
                // 添加
                resultTree.add(date);
            }
        }
        return resultTree;
    }


    /**
     * 构建递归树 （装逼写法）
     * @param dates 数据源
     * @param parentId  根路径ID
     * @return
     */
    public static <T> List<T> createTreePackB(List<T> dates, String parentId){
        return dates.stream()
                .filter(x -> ReflectUtil.getFieldValue(x, "parentId").equals(parentId))
                .peek(y -> ReflectUtil.setFieldValue(y, "children",
                        createTreePackB(dates, ReflectUtil.getFieldValue(y, "objId").toString())))
                .collect(Collectors.toList());
    }
}
