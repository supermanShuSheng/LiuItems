package com.shusheng.model.observer1;

import java.util.ArrayList;

/**
 * @author 刘闯
 * @date 2021/7/19.
 */
public class BookSubject implements Subject {

    private String bookName;

    ArrayList<Observer> aList;

    public BookSubject() {
        aList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        aList.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        aList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer :aList){
            if(observer != null){
                bookName = "java编程思想";
            }else{
                bookName = "c++编程思想";
            }
            assert observer != null;
            observer.update(bookName);
        }
    }
}
