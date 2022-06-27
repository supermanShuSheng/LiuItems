package com.shusheng.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sun.javafx.iio.ImageStorage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

/**
 * 二维码生成
 * @author 刘闯
 * @date 2021/5/27.
 */
public class QrCodeUtilDemo {
    public static void main(String[] args) throws IOException {
        // 直接生成一个文件
        QrCodeUtil.generate("我爱你!!!!", 300, 300, FileUtil.file("C:\\Users\\admin\\Desktop\\ccc.jpg"));
        // 生成一个二维码的字节数组
        byte[] generate = QrCodeUtil.generatePng("哈哈哈哈哈哈哈，我是一个存文本！！", QrConfig.create());
        // 写入文件
        FileUtil.writeBytes(generate,"C:\\Users\\admin\\Desktop\\ddd.jpg");
        System.out.println(" ============= ");
        // 解析二维码为存文本
        String decode = QrCodeUtil.decode(FileUtil.file("C:\\Users\\admin\\Desktop\\ddd.jpg"));
        System.out.println("decode = " + decode);
        // 将文本内容编码为条形码或二维码
//        BitMatrix encode = QrCodeUtil.encode("我爱你!！", BarcodeFormat.CODE_128, 100, 25);

        // 生成base64的二维码   IMAGE_TYPE_JPG
        String base64 = QrCodeUtil.generateAsBase64("我是aaaaa", QrConfig.create(), "JPG");
//        System.out.println("base64 = " + base64);
        // base64转字节数组
//        byte[] bytes = Base64.getDecoder().decode(base64);
//        FileUtil.writeBytes(bytes, FileUtil.file("C:\\Users\\admin\\Desktop\\lll.jpg"));

        createQrCodeN("我是谁！！！","C:\\Users\\admin\\Desktop\\ccc.jpg",300,300);
    }

    /**
     * 生成二维码
     * @param content 内容
     * @param logourl  logo
     */
    public static void createQrCodeN(String content, String logourl, int width, int height){
        QrConfig config = new QrConfig(width, height);
        //附带logo
        config.setImg(FileUtil.file(logourl));
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 高纠错级别
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(new Color(0,60,130).getRGB());
// 设置背景色（灰色）
        config.setBackColor(new Color(242,242,242).getRGB());

        //生成缓存流图片
        BufferedImage bufferedImage = QrCodeUtil.generate(
                content,
                config
        );
        try {
            ImageIO.write(bufferedImage, "PNG",
                    FileUtil.getOutputStream(FileUtil.file("C:\\Users\\admin\\Desktop\\zzz.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
