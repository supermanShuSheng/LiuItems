package com.shusheng.model.observer;

/**
 * 观察者模式测试类
 * @author 刘闯
 * @date 2021/6/30.
 */
public class DogTest {
    public static void main(String[] args) {
        Dog dog = new Dog();

        // 注册观察者
        new DogFlowers(dog);
        new DogGrass(dog);

        // 观测行为
        dog.setState(110);
    }
}
