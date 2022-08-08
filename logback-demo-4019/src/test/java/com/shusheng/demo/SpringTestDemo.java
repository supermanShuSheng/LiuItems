package com.shusheng.demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.shusheng.service.CimeParseAbstract;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author 刘闯
 * @date 2022/8/7
 */
@SpringBootTest
public class SpringTestDemo {

    @Autowired
    List<CimeParseAbstract<?>> cimeParseAbstract;

    @Resource(name = "threadPoolTask")
    private ThreadPoolTaskExecutor threadPoolTask;

    @Test
    public void demo01() {
        // 进行写入起始头
        File file = FileUtil.file("C:\\Users\\admin\\Desktop\\嘿嘿3.CIME");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(StrUtil.format("<!Entity={} type=电网模型 time='{}' !>\n", "驻马店", DateUtil.now()));

        // 执行Cime数据导出
        runBusCime(file);

        // 测试防止主线程结束 代码还未执行完成
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行Cime数据导出操作
     *
     * @param file
     */
    private void runBusCime(File file) {
        // 然后执行操作
        for (CimeParseAbstract<?> parseAbstract : cimeParseAbstract) {
            // 开启并发
            CompletableFuture.runAsync(() -> {
                // 执行业务操作
                List<?> cimeResourceList = parseAbstract.getCimeResourceList(Dict.create());
                parseAbstract.appendCimeLock(file, cimeResourceList, "驻马店");

            }, threadPoolTask).exceptionally(throwable -> {
                System.out.printf("线程%s发生错误,日志为：%s", Thread.currentThread().getName(), throwable.getMessage());
                return null;
            });
        }
    }
}