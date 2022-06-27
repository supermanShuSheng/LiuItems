package com.shusheng.demo;

import cn.hutool.core.io.FileUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/6/15.
 */
@RestController
public class PdfToJpg {

    @RequestMapping(value = "/getImg", method = RequestMethod.GET)
    public void getImg(HttpServletResponse response) throws IOException {
        byte[] bytes = FileUtil.readBytes(new File("C:\\Users\\admin\\Desktop\\Spring5框架课堂笔记.pdf"));

        List<byte[]> bytes1 = pdfToImage(bytes);
//        response.setContentType("image/jpeg");
//        response.getWriter().
        OutputStream out = response.getOutputStream();
        out.write(bytes1.get(0));
//        out.write(bytes1.get(1));
//        out.write(bytes1.get(2));
//        out.write(bytes1.get(3));
//        out.write(bytes1.get(4));
//        out.write(bytes1.get(5));
        out.flush();
//        return bytes1.get(0);
    }



//    public static void main(String[] args) throws IOException {
//        byte[] bytes = FileUtil.readBytes(new File("C:\\Users\\admin\\Desktop\\Spring5框架课堂笔记.pdf"));
//        List<byte[]> bytes1 = pdfToImage(bytes);
//    }

    /**
     * PDF转图片
     *
     * @param fileContent PDF文件的二进制流
     * @return 图片文件的二进制流
     */
    private static List<byte[]> pdfToImage(byte[] fileContent) throws IOException {
        /**
         * dpi越大转换后越清晰，相对转换速度越慢
         */
        final Integer DPI = 200;
        /**
         * 转换后的图片类型h
         */
        final String IMG_TYPE = "jpeg";

        List<byte[]> result = new ArrayList<>();

        PDDocument document = PDDocument.load(fileContent);
        PDFRenderer renderer = new PDFRenderer(document);
        for (int i = 0; i < document.getNumberOfPages(); ++i) {
            BufferedImage bufferedImage = renderer.renderImageWithDPI(i, DPI);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, IMG_TYPE, out);
            result.add(out.toByteArray());
        }

        return result;
    }
}
