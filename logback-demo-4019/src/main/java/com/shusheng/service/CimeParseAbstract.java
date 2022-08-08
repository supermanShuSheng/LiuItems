package com.shusheng.service;

import cn.hutool.core.lang.Dict;
import com.shusheng.utils.CimeBeanUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 刘闯
 * @date 2022/8/6
 */
public abstract class CimeParseAbstract<T> {

    /**
     * 加锁
     */
    private final static Lock lock = new ReentrantLock();

    /**
     * 获取开始标签
     */
    public String getBeginTag(String city){
        return "<{}::"+ city +">\n";
    }

    /**
     * 获取结束标签
     */
    public String getEndTag(String city){
        return "</{}::"+ city +">\n";
    }

    /**
     * 获取标题行以及注释
     */
    public <C> String getTitleLine(Class<C> cimeClass){
        return CimeBeanUtils.getCimeBeanBuff(cimeClass);
    }

    /**
     * 通过加文件锁的方式进行访问 暂时弃用
     * 将实体追加到Cime文件
     * @param file 文件
     * @param cimeList 实体泛型
     */
    public <C> void appendCimeFile(File file, List<C> cimeList) {
        FileLock lock = null;
        FileChannel channel = null;
        // 对文件加锁
        try {
            FileOutputStream fileOut = new FileOutputStream(file, true);
            channel = fileOut.getChannel();
            // 加锁
            while (true){
                // 尝试加锁
                try {
                    lock = channel.lock();
                    break;
                } catch (Exception e){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            // 加锁成功！ 开始写入
            appendLockFile(fileOut, cimeList, "新乡");
            // 释放锁
            lock.release();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (lock != null){
                    lock.close();
                }
                if (channel != null){
                    channel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 定义抽象方法 查询值信息
     * @param dict 传入字典值
     */
    public abstract List<T> getCimeResourceList(Dict dict);

    /**
     * 锁的方式进行追加
     * 将实体追加到Cime文件
     * @param file 文件
     * @param cimeList 实体泛型
     */
    public <C> void appendCimeLock(File file, List<C> cimeList, String city) {
        // 加锁成功！ 开始写入
        try {
            lock.lock();
            appendLockFile(new FileOutputStream(file, true), cimeList, city);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 追加操作 使用lock锁的方式进行追加
     * @param file
     * @param cimeList
     * @param <C>
     */
    private <C> void appendLockFile(FileOutputStream file, List<C> cimeList, String city) {
        // 追加信息
        try {
            file.write(getBeginTag(city).getBytes(StandardCharsets.UTF_8));
            if (cimeList != null && cimeList.size() > 0){
                file.write(getTitleLine(cimeList.get(0).getClass()).getBytes(StandardCharsets.UTF_8));
                // 将list追加到文件中
                CimeBeanUtils.appendListCime(file, cimeList);
            }
            file.write(getEndTag(city).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
