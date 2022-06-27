package com.shusheng.algorithm;

/**
 * @author 刘闯
 * @date 2021/8/26.
 */
public class ListNode {
    int val;            //数据 ：节点数据
    ListNode next;      //对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似

    ListNode(int val){  //构造方法 ：构造方法和类名相同
        this.val=val;     //把接收的参数赋值给当前类的val变量
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
