package com.shusheng.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.handler.inter.IWriter;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.io.FileUtil;
import com.shusheng.domain.CarTuo;
import com.shusheng.domain.Card;
import com.shusheng.mapper.AssetsMapper;
import com.shusheng.utils.PageUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author 刘闯
 * @date 2021/8/20.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AssCon {

    @Autowired
    AssetsMapper am;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    final static int pageNoNumber = 11;

    @Test
    public void getAssEt() throws IOException {
// 获取配置的数据源
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 查看配置数据源信息
        System.out.println(dataSource);
        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSourceProperties);

    }

    @Test
    public void getAssEt1() throws IOException {
        // 计算时间
        TimeInterval timer = DateUtil.timer();
        System.out.println(" 开始执行分析： ");

        ExportParams params = new ExportParams();

        IWriter<Workbook> workbookIWriter = ExcelExportUtil.exportBigExcel(params, CarTuo.class);

        // 写法1
        // 开启11个进程
//        CompletableFuture<List<CarTuo>> ct1 = startFuture(1);
//        CompletableFuture<List<CarTuo>> ct2 = startFuture(2);
//        CompletableFuture<List<CarTuo>> ct3 = startFuture(3);
//        CompletableFuture<List<CarTuo>> ct4 = startFuture(4);
//        CompletableFuture<List<CarTuo>> ct5 = startFuture(5);
//        CompletableFuture<List<CarTuo>> ct6 = startFuture(6);
//        CompletableFuture<List<CarTuo>> ct7 = startFuture(7);
//        CompletableFuture<List<CarTuo>> ct8 = startFuture(8);
//        CompletableFuture<List<CarTuo>> ct9 = startFuture(9);
//        CompletableFuture<List<CarTuo>> ct10 = startFuture(10);
//        CompletableFuture<List<CarTuo>> ct11 = startFuture(11);
//        // 并行
//        CompletableFuture.allOf(ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8, ct9, ct10, ct11);
//
//        // 写入数据
//        writeCar(workbookIWriter, ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8, ct9, ct10, ct11);
        // 写法二

        // 批量开启线程
        futureThread(workbookIWriter);

        System.out.println("转换数据花费了" + timer.intervalSecond() + "秒");

        System.out.println(" 开始写入Excel ");
        Workbook sheets = workbookIWriter.get();
        BufferedOutputStream outputStream = FileUtil.getOutputStream(FileUtil.file("C:\\Users\\admin\\Desktop\\123111.xlsx"));
        sheets.write(outputStream);
        outputStream.flush();
        outputStream.close();

        System.out.println("执行完成花费了" + timer.intervalSecond() + "秒");
    }

    /**
     * 写入数据
     *
     * @param workbookIWriter 写入数据
     * @param cards           查询集合
     */
    @SafeVarargs
    private final void writeCar(IWriter<Workbook> workbookIWriter, CompletableFuture<List<CarTuo>>... cards) {
        for (CompletableFuture<List<CarTuo>> card : cards) {
            workbookIWriter.write(card.join());
        }
    }


    CompletableFuture<Void> startFuture(Integer pageNo, IWriter<Workbook> workbook) {
        return CompletableFuture.runAsync(
                () -> {
                    System.out.println(" 开启线程: " + Thread.currentThread().getName());
                    PageUtils.startPage(pageNo, 150000);
                    List<Card> cards = am.getCards();
                    if (cards == null || cards.size() == 0) {
                        return;
                    }
                    List<CarTuo> ct = joinTogether(cards);
                    synchronized (workbook) {
                        workbook.write(ct);
                    }
                    System.out.println("线程：" + Thread.currentThread().getName() + " 转化完成！ 长度为" + cards.size());
                }, threadPoolTaskExecutor);
    }

    CompletableFuture<List<CarTuo>> startFuture(Integer pageNo) {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(" 开启线程: " + Thread.currentThread().getName());
                    PageUtils.startPage(pageNo, 150000);
                    List<Card> cards = am.getCards();
                    if (cards == null || cards.size() == 0) {
                        return null;
                    }
                    List<CarTuo> ct = joinTogether(cards);
                    System.out.println("线程：" + Thread.currentThread().getName() + " 转化完成！ 长度为" + cards.size());
                    return ct;
                }, threadPoolTaskExecutor);
    }

    /**
     * 开始N个线程并进行收集数据
     *
     * @param workbook 数据源
     */
    void futureThread(IWriter<Workbook> workbook) {
        List<CompletableFuture<Void>> ctList = new ArrayList<>();
        for (int i = 1; i <= AssCon.pageNoNumber; i++) {
            ctList.add(startFuture(i, workbook));
        }
        CompletableFuture.allOf(ctList.toArray(new CompletableFuture[0])).join();
    }


    /**
     * 组装成新的信息
     * @param cards 卡信息
     * @return 新类
     */
    private List<CarTuo> joinTogether(List<Card> cards) {
        List<CarTuo> ct = new ArrayList<>();
        cards.forEach(x -> {
            CarTuo c = new CarTuo();
            c.setYuanName(x.getOldCardName());
            c.setTuoName(x.getCardName());
            c.setYuanAdd(x.getOldAddr());
            c.setTuoAdd(x.getAddr());
            ct.add(c);
        });
        return ct;
    }

    @Test
    public void  getDate(){
        int a = am.updateDate();
        System.out.println("a = " + a);
    }
}
