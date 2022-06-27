package com.shusheng.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.alibaba.fastjson.JSONObject;
import com.shusheng.commons.R;
import com.shusheng.domain.FileUserEntity;
import com.shusheng.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * @author 刘闯
 * @date 2021/6/4.
 */

@RestController
@RequestMapping("/docs")
@Api(tags = "逻辑数据")
public class DocsController {

    /**
     * 通过ID获取用户对象
     * @param id  用户ID
     * @return  用户实体
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public String getUserInfo(@RequestParam("id") String id){
        return "ID为："+id;
    }

    /**
     * 通过ID获取用户对象
     * @param jsonObject  用户ID
     * @return  用户实体
     */
    @RequestMapping(value = "/getPostBody",method = RequestMethod.POST)
    public JSONObject getPostBody(@RequestBody JSONObject jsonObject){
        return jsonObject;
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public R uploadFiles(@RequestParam(value = "fileUser") String fileUser, MultipartFile[] multipartFiles){
        FileUserEntity fileUserEntity = JSONObject.parseObject(fileUser, FileUserEntity.class);

        System.out.println("fileUserEntity = " + fileUserEntity);
         // 遍历文件
         Arrays.stream(multipartFiles).forEach(x->{
            String filePath = "C:\\Users\\admin\\Desktop\\image\\"+x.getOriginalFilename();
            System.out.println("文件保存路径： "+filePath);
            // 获取字节数据
            byte[] bytes = new byte[0];
            try {
                bytes = x.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileUtil.writeBytes(bytes,filePath);
        });

        return ResultUtils.success();
    }

    /**
     * 方式一
     *
     */
    @RequestMapping(value = "/getImgOne", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageOne(@RequestParam(value = "md5") String md5){
        switch (md5){
            case "001":
                return FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\789.jpg"));
            case "002":
                return FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\123.jpg"));
            case "003":
                return FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\456.gif"));
        }
        return null;
    }

    /**
     * 方式五  返回实体对象
     */
    @RequestMapping(value = "/getImgFive", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImgFive() throws UnsupportedEncodingException {
        File file = FileUtil.file("C:\\Users\\admin\\Desktop\\淘票票");
        File zip = ZipUtil.zip(file);
        System.out.println("zip = " + zip);
        byte[] bytes = FileUtil.readBytes(zip);

        HttpHeaders headers = new HttpHeaders();
        // 设置响应头  查看图片
//        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE);

        // 设置下载响应头
        headers.add(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_OCTET_STREAM_VALUE);

        // 如果设置文件名  则会进行文件的下载
        headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="
                + URLEncoder.encode("aaa.zip", "UTF-8"));
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK) ;
    }

    /**
     * 方式四  返回base64
     */
    @RequestMapping(value = "/getImgFore", method = RequestMethod.GET)
    public String getImgFore(){
        return Base64.encode(FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\456.gif")));
    }


}
