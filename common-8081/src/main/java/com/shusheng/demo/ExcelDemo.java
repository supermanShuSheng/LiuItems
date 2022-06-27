package com.shusheng.demo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.google.zxing.BarcodeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2022/3/18.
 */

public class ExcelDemo {
    public static void main(String[] args) throws IOException {
        BufferedImage generate = QrCodeUtil.generate("1234567895", BarcodeFormat.CODE_39, 400, 75);
        BufferedImage generate1 = QrCodeUtil.generate("ABCDDFRERTE", BarcodeFormat.CODE_39, 400, 75);

        List<LiuDemo> ex = new ArrayList<>();
//        ex.add(new LiuDemo("乐电", generateBytes(generate)));
//        ex.add(new LiuDemo("乐电123", generateBytes(generate1)));

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), LiuDemo.class, ex);
        FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\Desktop\\zzz.xls");
        workbook.write(fos);
        fos.close();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class LiuDemo {

        @Excel(name = "标题一")
        private String titleOne;

        @Excel(name = "管理单位")
        private String dataOne;

        @Excel(name = "管理单位", type = 2, width = 40, imageType = 2)
        private byte[] txmBytes;
    }


    private static byte[] generateBytes(BufferedImage bi){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, "png", baos );
            baos.flush();
            baos.close();
        } catch (IOException e) {
            try {
                baos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
}



