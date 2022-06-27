package com.shusheng.model.observer;

/**
 * 够花观察者
 * @author 刘闯
 * @date 2021/6/30.
 */
public class DogFlowers extends Observer{

    public DogFlowers(Dog dog) {
        // 要监听的对象
        this.dog = dog;
        this.dog.addObserver(this);
    }

    @Override
    public void dogCall() {
        System.out.println("DogFlowers: " + dog.getState());
    }
}
