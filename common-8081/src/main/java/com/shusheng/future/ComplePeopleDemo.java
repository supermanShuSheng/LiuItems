package com.shusheng.future;

import cn.hutool.core.date.DateUtil;
import com.shusheng.domain.Do.UserDo;
import com.shusheng.domain.People;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
public class ComplePeopleDemo implements Supplier<List<People>> {

    @Override
    public List<People> get() {
        System.out.println(" 开启线程池People === " + DateUtil.date());
        List<People> people = new ArrayList<>();
        people.add(new People(1,1,"1"));
        people.add(new People(2,2,"2"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" People执行了一半！ ");
        people.add(new People(3,3,"3"));
        people.add(new People(4,1,"1"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("People查询完毕 === " + DateUtil.date());
        return people;
    }
}
