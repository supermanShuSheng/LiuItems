package com.shusheng.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2021/3/26.
 */
public class ExcelDemo {
    public static void main(String[] args) {
        try {
            List<LiuDto> list = ExcelImportUtil.importExcel(
                    new FileInputStream("C:\\Users\\admin\\Desktop\\水.xlsx"),
                    LiuDto.class, new ImportParams());

            Map<String, Double> collect = list.stream().collect(Collectors.groupingBy(x -> {
                return x.getCtnb() + "===" + x.getCtn() + "----" + x.getDate().substring(0, 4);
            }, Collectors.averagingDouble(LiuDto::getPm)));

            List<LiuVo> liuVos = new ArrayList<>();
            collect.forEach((x,y)->{
                LiuVo liuVo = new LiuVo();
                String[] split = x.split("===");
                String[] split1 = split[1].split("----");
                liuVo.setCtnb(split[0]);
                liuVo.setCtn(split1[0]);
                liuVo.setDate(split1[1]);
                liuVo.setPm(y);
                liuVos.add(liuVo);
            });

            //  Excel导出
            ExportParams params = new ExportParams(null, "年统计", ExcelType.XSSF);
            // 指定单元格转换字典
            Workbook workbook = ExcelExportUtil.exportExcel(params, LiuVo.class, liuVos);
            File saveFile = new File("excel");
            if (!saveFile.exists()) {
                saveFile.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("excel/年统计.xlsx");
            workbook.write(fos);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
