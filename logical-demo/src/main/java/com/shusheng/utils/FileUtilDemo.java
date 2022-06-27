package com.shusheng.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * IO操作
 * @author 刘闯
 * @date 2021/5/27.
 */
public class FileUtilDemo {
    public static void main(String[] args) {
        List<File> ls1 = FileUtil.loopFiles("C:\\Users\\admin\\Desktop\\Doc1.docx");

        for (File file1 : ls1) {
            System.out.println("file1.getName() = " + file1.getName());
        }
    }


    public static void test1() throws InterruptedException {
        File file = QrCodeUtil.generate("我爱你", 300, 300, FileUtil.file("C:\\Users\\admin\\Desktop\\aaa.jpg"));
        // 创建文件 如果父目录不存在 会自动创建父目录
        FileUtil.touch(file);
        // 查看该目录下的所有文件
        File[] ls = FileUtil.ls("C:\\Users\\admin\\Desktop");
        Arrays.stream(ls).forEach(x->{
            System.out.println("x.getName() = " + x.getName());
        });
        // 创建目录 如果父目录不存在 也会进行父目录的创建
        FileUtil.mkdir(FileUtil.file("C:\\Users\\admin\\Desktop\\123\\456\\刘闯"));
        // 测试是否创建成功
        Thread.sleep(100);

        // 递归删除目录
        FileUtil.del(FileUtil.file("C:\\Users\\admin\\Desktop\\123"));
        // 将文件读取为字节数组
        byte[] bytes = FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\aaa.jpg"));
        // 将字节数组写到文件里
        FileUtil.writeBytes(bytes,FileUtil.file("C:\\Users\\admin\\Desktop\\bbb.jpg"));



    }


}
