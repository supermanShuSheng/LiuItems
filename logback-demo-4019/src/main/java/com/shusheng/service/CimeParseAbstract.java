package com.shusheng.service;

import com.shusheng.utils.CimeBeanUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author 刘闯
 * @date 2022/8/6
 */
public abstract class CimeParseAbstract {

    /**
     * 城市
     */
    public String CITY = "新乡";

    /**
     * 获取开始标签
     * @return
     */
    public String getBeginTag(){
        return "<{}::"+CITY+">\n";
    }

    /**
     * 获取结束标签
     * @return
     */
    public String getEndTag(){
        return "</{}::"+CITY+">\n";
    }

    /**
     * 获取标题行以及注释
     * @return
     */
    public <T> String getTitleLine(Class<T> cimeClass){
        return CimeBeanUtils.getCimeBeanBuff(cimeClass);
    }

    /**
     * 将实体追加到Cime文件
     * @param file 文件
     * @param cimeList 实体泛型
     */
    public <T> void appendCimeFile(File file, List<T> cimeList) {
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
            appendLockFile(fileOut, cimeList);
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
     * 追加操作
     * @param file
     * @param cimeList
     * @param <T>
     */
    private <T> void appendLockFile(FileOutputStream file, List<T> cimeList) {

        // 追加信息
        try {
            file.write(getBeginTag().getBytes(StandardCharsets.UTF_8));
            if (cimeList != null && cimeList.size() > 0){
                file.write(getTitleLine(cimeList.get(0).getClass()).getBytes(StandardCharsets.UTF_8));
                CimeBeanUtils.appendListCime(file, cimeList);
            }
            file.write(getEndTag().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
