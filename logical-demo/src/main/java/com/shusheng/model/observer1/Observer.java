package com.shusheng.model.observer1;

/**
 * 观察者
 * @author 刘闯
 * @date 2021/7/19.
 */
public interface Observer {

    /**
     * 更新时
     * @param name
     */
    void update(String name);

    /**
     * 取消观察
     */
    void disConnect();

}
