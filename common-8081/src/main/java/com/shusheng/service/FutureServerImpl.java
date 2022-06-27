package com.shusheng.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.shusheng.commons.R;
import com.shusheng.domain.People;
import com.shusheng.future.FuturePeopleDemo;
import com.shusheng.utils.ResultUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
@Service
public class FutureServerImpl {

    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    // 获取线程
    public R getFuture() {
        //通过线程池管理多线程
        try {
            TimeInterval timer = DateUtil.timer();
            List<Object> result = new ArrayList<>();
            System.out.println("开始执行多线程 === " + DateUtil.date());
            List<Future> list = new ArrayList<>();

            System.out.println("开始执行UserDo线程");
//            Future<List<UserDo>> submit = threadPoolTaskExecutor.submit(new FutureDemo(new UserQueryDto(), userMapper));
//            list.add(submit);
            System.out.println("开始执行People线程");
            Future<List<People>> submit1 = threadPoolTaskExecutor.submit(new FuturePeopleDemo());
            list.add(submit1);

            threadPoolTaskExecutor.submit(()->{
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
            });

            while (!list.isEmpty()){
                Iterator<Future> iterator = list.iterator();
                while (iterator.hasNext()){
                    Future next = iterator.next();
                    if (next.isDone() && !next.isCancelled()){
                        Object o = next.get();
                        result.add(o);
                        System.out.println(" 结果为 ==== " + o);
                        iterator.remove();
                    }
                }
                Thread.sleep(1);
            }

            System.out.println("size ==== " + list.size());

            System.out.println("花费毫秒数 = " + timer.interval());
            return ResultUtils.success(result, result.size());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
