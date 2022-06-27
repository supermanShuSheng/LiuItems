package com.shusheng.model.observer;

/**
 * @author 刘闯
 * @date 2021/6/30.
 */
public class DogGrass extends Observer{

    public DogGrass(Dog dog) {
        this.dog = dog;
        this.dog.addObserver(this);
    }

    // 行为
    @Override
    public void dogCall() {
        System.out.println("DogGrass: " + dog.getState());
    }
}
