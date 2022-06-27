package com.shusheng.model.combination;

/**
 * @author 刘闯
 * @date 2021/7/19.
 */
public class TreeDemo {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode("螺丝帽");

        TreeNode tree1 = new TreeNode("螺丝帽1");
        TreeNode tree2 = new TreeNode("螺丝帽2");

        TreeNode treeA = new TreeNode("螺丝帽A");
        TreeNode treeB = new TreeNode("螺丝帽B");


        tree1.add(treeA);
        tree1.add(treeB);

        tree.add(tree1);
        tree.add(tree2);

        System.out.println("tree = " + tree);
    }
}
