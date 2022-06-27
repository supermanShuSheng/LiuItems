package com.shusheng.readfile;


import cn.hutool.core.util.PageUtil;

import java.io.FileNotFoundException;

/**
 * @author 刘闯
 * @date 2021/5/27.
 */
public class FileReaderDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // 进行文件的读取
//        FileReader fileReader = new FileReader("C:\\Users\\admin\\Desktop\\委托书.docx");
//        fileReader.writeToStream(new FileOutputStream("C:\\Users\\admin\\Desktop\\123.txt"));
//
//        byte[] s = fileReader.readBytes();
//
//        String str = StrUtil.str(s, "GBK");
//
//        System.out.println("str = " + str);

//        StrUtil
        int i = PageUtil.totalPage(98, 10);
        System.out.println(i);
        int start = PageUtil.getStart(0, 10);
        System.out.println("start = " + start);
//        PageUtil.rainbow()
    }
}
