package com.shusheng.distinct;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 文件夹判空处理或少于3个（不包含三个）
 * @author 刘闯
 * @date 2021/10/3.
 */
public class Sentenced {

    private static final HashSet<String> map = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件目录路径：");
        String filePath = scanner.nextLine().trim();

        System.out.println("\t\t开始进行空文件查询以及文件夹中少于3个文件的（不包含3个文件）");
        // 递归查询查询空目录
        fileIsEmpty(filePath);
        // 输出文件绝对路径
        printAbsoluteFile();
        // 结束
        gameOver(scanner);
    }

    /**
     * 输出文件绝对路径
     */
    private static void printAbsoluteFile() {
        // 排序
        TreeSet<String> tree = new TreeSet<>(map);

        System.out.println(" 扫描到"+ tree.size() + "个文件！ ");
        tree.forEach(x->{
            System.out.println(" 文件路径为： " + x);
        });
    }


    // 空目录递归查询
    private static void fileIsEmpty(String filePath){
        try {
            if (!FileUtil.isDirectory(filePath)){
                return;
            }
            // 当前文件夹递归目录下的所有文件（不包含文件夹）
            List<File> files = FileUtil.loopFiles(filePath);
            if (files.size() < 3) {
                map.add(filePath);
            }
            // 当前文件夹下的文件个数
            File[] ls = FileUtil.ls(filePath);
            for (File file : ls) {
                fileIsEmpty(file.getAbsolutePath());
            }
        } catch (Exception e){
            System.out.println("文件读取异常！");
        }
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
}
