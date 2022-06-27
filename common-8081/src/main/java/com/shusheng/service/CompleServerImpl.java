package com.shusheng.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.shusheng.commons.R;
import com.shusheng.domain.People;
import com.shusheng.future.ComplePeopleDemo;
import com.shusheng.utils.ResultUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
@Service
public class CompleServerImpl {

    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    // 获取线程
    public R getFuture() throws ExecutionException, InterruptedException {
        try {
            TimeInterval timer = DateUtil.timer();
            Map<String, Object> hashMap = new HashMap<>();
            String str = null;
            // 开启异步线程
//            CompletableFuture<List<UserDo>> userDo = CompletableFuture.supplyAsync(new CompletableDemo(new UserQueryDto(), userMapper),
//                    threadPoolTaskExecutor);
            CompletableFuture<List<People>> comple = CompletableFuture.supplyAsync(new ComplePeopleDemo(),
                    threadPoolTaskExecutor);

            // 只消费不进行返回
           CompletableFuture.allOf(comple).join();
//           hashMap.put("UserDo", userDo.join());
           hashMap.put("People", comple.join());

//            list.add(join);
//            list.add(userDo.join());
//            list.add(comple.join());

            System.out.println("花费了 === " + timer.interval());

//            System.out.println("list = " + list);

            return ResultUtils.success(hashMap, hashMap.size());
        } catch (Exception e){
            return ResultUtils.error(e.getMessage());
        }
    }
}
