package com.shusheng.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/6/30.
 */
public class Dog {
    // 自己的观察者
    private final List<Observer> observers = new ArrayList<>();
    // 属性
    private int state;

    public int getState() {
        return state;
    }

    // 如果属性值有变动 则通知所有的观察者
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    // 通知所有的观察者
    public void notifyAllObservers() {
        observers.forEach(Observer::dogCall);
    }

    // 添加观察者
    public void addObserver(Observer observer){
        observers.add(observer);
    }


}
