package com.shusheng.model.observer1;

/**
 * 观察者通知
 * @author 刘闯
 * @date 2021/7/19.
 */
public interface Subject {
    /**
     * 注册观察者
     * @param o
     */
    public void registerObserver(Observer o);

    /**
     * 移除观察者
     * @param o
     */
    public void removeObserver(Observer o);

    /**
     * 通知观察者
     */
    public void notifyObservers();
}
