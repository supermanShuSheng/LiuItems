package com.shusheng.excel.complex;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/3/26.
 */
public class complexExcel {

    public static void main(String[] args) {
        String path = "C:\\Users\\admin\\Desktop\\电坐标提取.xlsx";

        System.out.println("读取路径为 == " + path);
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
//        importParams.setTitleRows(1);
//        importParams.setStartSheetIndex(3);

        try {
            List<ExcelWaterEntity> list = ExcelImportUtil.importExcel(
                    new FileInputStream(path),
                    ExcelWaterEntity.class, importParams);
            System.out.println("返回数据为 == " + list);
            System.out.println("数据总条数为 == " + list.size());

            System.out.println(JSONObject.toJSONString(list, SerializerFeature.WriteNullStringAsEmpty));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
