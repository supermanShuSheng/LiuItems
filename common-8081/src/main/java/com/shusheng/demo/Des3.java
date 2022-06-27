package com.shusheng.demo;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.nio.charset.StandardCharsets;


/**
 * @author ：dxf
 * 加密模式 DESede/ECB/PKCS5Padding
 * @date ：2021/3/7 15:26
 */
public class Des3 {

    // 3DESECB加密,key必须是长度大于等于 3*8 = 24 位哈
    public static String encryptThreeDESECB(final String src, final String key) throws Exception {
        final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes(StandardCharsets.UTF_8));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        final SecretKey securekey = keyFactory.generateSecret(dks);

        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, securekey);
        final byte[] b = cipher.doFinal(src.getBytes(StandardCharsets.UTF_8));

       // final BASE64Encoder encoder = new BASE64Encoder();
        String AES_encode = new String(Base64.encodeBase64(b));
        //return encoder.encode(b).replaceAll("\r", "").replaceAll("\n", "");
        return AES_encode.replaceAll("\r", "").replaceAll("\n", "");
    }

    // 3DESECB解密,key必须是长度大于等于 3*8 = 24 位
    public static String decryptThreeDESECB(final String src, final String key) throws Exception {
        System.out.println("解密密文"+src);
        // --通过base64,将字符串转成byte数组
//        final BASE64Decoder decoder = new BASE64Decoder();
//        final byte[] bytesrc = decoder.decodeBuffer(src);
        final byte[] bytesrc  = Base64.decodeBase64(src);//解决发行警告
        // --解密的key
        final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes(StandardCharsets.UTF_8));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        final SecretKey securekey = keyFactory.generateSecret(dks);

        // --Chipher对象解密
        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, securekey);
        final byte[] retByte = cipher.doFinal(bytesrc);
        String result = new String(retByte, StandardCharsets.UTF_8);
        return result;
    }


    public static void main(String[] args) throws Exception {
        final String key = "91b2dcf4511841ba868d4b2792581837";
        // 加密流程
        String telePhone = "{\"phone\":\"18738470890\",\"message\":\"ces123\"}";
        System.out.println("输入参数："+telePhone);
        Des3 threeDES = new Des3();
        String telePhone_encrypt = "";
        telePhone_encrypt = encryptThreeDESECB(telePhone, key);
        System.out.println("密文："+telePhone_encrypt);// nWRVeJuoCrs8a+Ajn/3S8g==

        // 解密流程
        String tele_decrypt = decryptThreeDESECB(telePhone_encrypt, key);
        System.out.println("模拟代码解密:" + tele_decrypt);
    }
}
