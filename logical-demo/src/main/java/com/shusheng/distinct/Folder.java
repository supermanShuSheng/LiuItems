package com.shusheng.distinct;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 进行文件夹去重
 * @author 刘闯
 * @date 2021/9/7.
 */
public class Folder {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件目录路径：");
        String filePath = scanner.nextLine().trim();
        // 存储结果集
        Map<String, String> map = new HashMap<>();
        // 获取所有文件
        List<File> files = loopFiles(filePath);
        // 处理文件
        dealFileName(files, map);
        // 输出
        printFileInfo(map);
    }

    /**
     * 进行文件读取
     * @param filePath
     * @return
     */
    private static List<File> loopFiles(String filePath){
        try{
            return FileUtil.loopFiles(filePath);
        } catch (Exception e){
            throw new RuntimeException("文件读取失败！");
        }
    }

    /**
     * 输出文件结果
     * @param map
     */
    private static void printFileInfo(Map<String, String> map){
        if (map.size() == 0){
            System.out.println("无重复数据！");
            return;
        }
        System.out.println("重复数据为：");
        // 进行遍历输出
        map.forEach((x,y)->{
            System.out.println("文件名称：" + x + "   重复路径为（以逗号进行隔开）：" + y);
        });
    }

    /**
     * 整理重复文件
     * @param map
     */
    private static void dealFileName(List<File> files, Map<String, String> map){
        // 基本映射 存储所有结果
        Map<String, String> all = new HashMap<>();
        // 进行文件重复处理
        for (File file : files) {
            String name = file.getName();
            String path = file.getPath();
            // 找到重复数据
            if (all.containsKey(name)){
                // 如果有两个以上的重复
                if (map.containsKey(name)){
                    map.put(name, map.get(name)+" , "+path);
                } else {
                    map.put(name, all.get(name)+" , "+path);
                }
            }
            all.put(name, path);
        }
    }
}
