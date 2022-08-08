package com.shusheng.demo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.Data;
import org.apache.poi.ss.usermodel.CellType;

import java.util.HashMap;
import java.util.List;

/**
 * @author 刘闯
 * @date 2022/7/22
 */
public class ExcelPortDemo {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\admin\\Desktop\\ExcelDemo.xlsx";

        ExcelReader reader = ExcelUtil.getReader(filePath);
        // 设置别名
        HashMap<String, String> map = new HashMap<>();
        map.put("姓名", "name");
        map.put("日期", "date");

        reader.setHeaderAlias(map);
        reader.setCellEditor((cell, value) -> {
            if (cell.getCellType() == CellType.NUMERIC){
                double numericCellValue = cell.getNumericCellValue();

                try {
                    return DateUtil.secondToTime(Convert.toInt(NumberUtil.round(numericCellValue * 24 * 3600, 6)));
                } catch (Exception e){
                    return value;
                }
            }
            return value;
        });

        List<Abc> abcs = reader.readAll(Abc.class);

        System.out.println(abcs);
    }


    @Data
    public static class Abc {

        private String name;

        private String date;

        public void setDate(String date) {
            this.date = date;
        }
    }
}
