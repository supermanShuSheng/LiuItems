package com.shusheng.distinct;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件目录路径：");
        String filePath = scanner.nextLine().trim();
        // 获取所有文件
        List<File> files = loopFiles(filePath);
        // 进行文件夹名称重复判断
        repeatName(files, scanner);
        // 进行精确匹配
        accurateFile(files, scanner);
        // 结束判断
        gameOver(scanner);
    }

    /**
     * 是否进行精确匹配
     * @param files  文件集合
     * @param sc 输出指令
     */
    private static void accurateFile(List<File> files, Scanner sc) {
        System.out.print("\t\t----------------------------------------\n是否进行精确匹配：");
        String blag = sc.nextLine();
        if (!blag.equals("是")){
            return;
        }
        // 存储结果集
        Map<String, String> map = new HashMap<>();
        // 基本映射 存储所有结果
        Map<String, String> all = new HashMap<>();
        // 进行文件重复处理
        for (File file : files) {
            String name = DigestUtils.md5Hex(FileUtil.readBytes(file));
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
        printFileInfo(map, true);
    }

    /**
     * 程序结束
     */
    private static void gameOver(Scanner sc) {
        System.out.println("\n\n程序执行结束！输入-1退出");
        while(!sc.nextLine().equals("-1")){
            System.out.println("程序需要重新启动！");
        }
        sc.close();
    }

    /**
     * 进行文件名重复抉择
     * @param files  文件集合
     * @param scanner 输出指令
     */
    private static void repeatName(List<File> files, Scanner scanner){
        // 存储结果集
        Map<String, String> map = new HashMap<>();
        // 处理文件
        dealFileName(files, map, scanner);
        // 输出
        printFileInfo(map, false);
    }

    /**
     * 进行文件读取
     * @param filePath 文件路径
     */
    private static List<File> loopFiles(String filePath){
        try{
            List<File> files = FileUtil.loopFiles(filePath);
            System.out.println("已扫描到"+files.size()+"个文件");
            return files;
        } catch (Exception e){
            throw new RuntimeException("文件读取失败！");
        }
    }

    /**
     * 输出文件结果
     * @param map 结果集
     */
    private static void printFileInfo(Map<String, String> map, boolean blag){
        if (map.size() == 0){
            System.out.println("无重复数据！");
            return;
        }
        System.out.println("重复数据为：");
        // 进行遍历输出
        map.forEach((x,y)->{
            System.out.println((blag?"图片内容相同的":"文件名称：" + x + "    ") + "重复路径为（以逗号进行隔开）：" + y);
        });
    }

    /**
     * 整理重复文件
     * @param map 结果
     */
    private static void dealFileName(List<File> files, Map<String, String> map, Scanner sc){
        System.out.print("是否输出决定路径：");
        String blag = sc.nextLine();
        // 基本映射 存储所有结果
        Map<String, String> all = new HashMap<>();
        // 进行文件重复处理
        for (File file : files) {
            String name = file.getName();
            String path = StrUtil.equals(blag, "是")?file.getPath():file.getParentFile().getName();
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

    /**
     * 判断两个文件是否相同
     * @param fileByte1 文件一
     * @param fileByte2  文件二
     * @return  true  false
     */
    private static boolean isSameFiles(byte[] fileByte1, byte[] fileByte2) {
        String firstFileMd5= DigestUtils.md5Hex(fileByte1);
        String secondFileMd5= DigestUtils.md5Hex(fileByte2);

        return firstFileMd5.equals(secondFileMd5);
    }
}
