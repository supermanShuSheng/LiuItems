package com.shusheng.model.observer1;

/**
 * @author 刘闯
 * @date 2021/7/19.
 */
public class XiaoMingObserver implements Observer{

    String bookName;

    private Subject subject;

    public XiaoMingObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }
    @Override
    public void update(String name) {
        System.out.println ("i am xiaoMing,the new book is "+name);
    }
    @Override
    public void disConnect() {
        this.subject.removeObserver(this);
    }
}
