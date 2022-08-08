package com.shusheng.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.shusheng.service.CimeParseAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author 刘闯
 * @date 2022/8/8
 */
@RestController
public class WriteCimeController {

    @Autowired
    List<CimeParseAbstract<?>> cimeParseAbstract;

    @Resource(name = "threadPoolTask")
    private ThreadPoolTaskExecutor threadPoolTask;

    @GetMapping("/cime")
    public void demo01(@RequestParam("city") String city, @RequestParam("path") String path) {
        // 进行写入起始头
        File file = FileUtil.file("C:\\Users\\admin\\Desktop\\" + path);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(StrUtil.format("<!Entity={} type=电网模型 time='{}' !>\n", city, DateUtil.now()));

        // 执行Cime数据导出
        runBusCime(file, city);

        // 测试防止主线程结束 代码还未执行完成
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行Cime数据导出操作
     * @param file
     */
    private void runBusCime(File file, String city) {
        // 然后执行操作
        for (CimeParseAbstract<?> parseAbstract : cimeParseAbstract) {
            // 开启并发
            CompletableFuture.runAsync(()->{
                // 执行业务操作
                List<?> cimeResourceList = parseAbstract.getCimeResourceList(Dict.create());
                parseAbstract.appendCimeLock(file, cimeResourceList, city);

            }, threadPoolTask).exceptionally(throwable -> {
                System.out.printf("线程%s发生错误,日志为：%s", Thread.currentThread().getName(), throwable.getMessage());
                return null;
            });
        }
    }

}
