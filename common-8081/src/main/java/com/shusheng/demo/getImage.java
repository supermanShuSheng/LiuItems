package com.shusheng.demo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.google.zxing.BarcodeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author 刘闯
 * @date 2021/6/15.
 */
@RestController
public class getImage {

    /**
     * 方式一
     *
     */
    @RequestMapping(value = "/getImgOne", method = RequestMethod.GET, produces = {MediaType.APPLICATION_PDF_VALUE,
            MediaType.IMAGE_JPEG_VALUE})
    public byte[] getImageOne(@RequestParam("filePath") String filePath){
        return FileUtil.readBytes(FileUtil.file(filePath));
    }

    /**
     * 方式二 返回缓存流  配置（WebMvcConfig）就可以显示图片
     * @return 图片
     */
    @RequestMapping(value = "/getImgTwo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage getImgTwo() throws IOException {
        return ImageIO.read(new FileInputStream("C:\\Users\\admin\\Desktop\\home.jpg"));
    }

    /**
     * 方式三
     */
    @RequestMapping(value = "/getImgThree", method = RequestMethod.GET)
    public void getImgThree(HttpServletResponse response) throws IOException {
        byte[] bytes = FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\home.jpg"));
        OutputStream out = response.getOutputStream();
        out.write(bytes);
        out.flush();
    }

    /**
     * 方式三
     */
    @RequestMapping(value = "/getTxmThree", method = RequestMethod.GET)
    public void getTxmThree(HttpServletResponse response) throws IOException {
        BufferedImage image = QrCodeUtil.generate("123456789111", BarcodeFormat.UPC_A, 1000, 500);

        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    /**
     * 方式四  返回base64
     */
    @RequestMapping(value = "/getImgFore", method = RequestMethod.GET)
    public String getImgFore(){
        return Base64.encode(FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\home.jpg")));
    }

    /**
     * 方式五  返回实体对象
     */
    @RequestMapping(value = "/getImgFive", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImgFive() throws UnsupportedEncodingException {
        byte[] bytes = FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\123.gif"));
        HttpHeaders headers = new HttpHeaders();
        // 设置响应头  查看图片
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE);

        // 设置下载响应头
        // headers.add(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_OCTET_STREAM_VALUE);

        // 如果设置文件名  则会进行文件的下载
//        headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="
//                + URLEncoder.encode("home1.jpg", "UTF-8"));
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK) ;
    }

    /**
     * 下载图片
     */
    @RequestMapping(value = "/downloadImgOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] downloadImgOne(HttpServletResponse response) throws UnsupportedEncodingException {
        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名称
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode("home.jpg", "UTF-8"));
        return FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\home.jpg"));
    }

    @RequestMapping(value = "/downloadPdf", method = RequestMethod.GET)
    public void download(@RequestParam(value = "filePath") String filePath, @RequestParam(required = false, defaultValue = "true") boolean isOnLine, HttpServletResponse response) {
        try {
            //获取要下载文件的绝对路劲
            File f = new File(filePath);
            if (!f.exists()) {
                response.sendError(404, "File not found!");
                return;
            }
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
            byte[] buf = new byte[1024];
            int len = 0;

            response.reset(); // 非常重要
            if (isOnLine) { // 在线打开方式
                URL u = new URL("file:///" + filePath);
                response.setContentType(u.openConnection().getContentType());
                response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
                // 文件名应该编码成UTF-8
            } else { // 纯下载方式
                response.setContentType("application/x-msdownload");
                response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(f.getName(),"UTF-8"));
            }
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0){
                out.write(buf, 0, len);
            }
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
