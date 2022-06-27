package com.shusheng.model.observer;

/**
 * 观察者
 * @author 刘闯
 * @date 2021/6/30.
 */
public abstract class Observer {
    // 要观察的对象
    protected Dog dog;
    // 如果有变化观察者执行的行为！
    public abstract void dogCall();
}
