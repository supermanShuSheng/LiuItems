package com.shusheng.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.io.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/3/26.
 */
@RestController
public class WaterExcel {

    /**
     * 导入excel
     * @param path 路径
     * @return json格式串
     */
    @RequestMapping(value = "/getWater", method = RequestMethod.GET)
    public List<Water> getWater(String path){
        System.out.println("读取路径为 == " + path);
        try {
            List<Water> list = ExcelImportUtil.importExcel(
                    new FileInputStream(path),
                    Water.class, new ImportParams());
            System.out.println("返回数据为 == " + list);
            System.out.println("数据总条数为 == " + list.size());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 导出excel
     */
    @RequestMapping(value = "/writeUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] writeUser(HttpServletResponse response) throws IOException {
        List<UserExcel> userExcels = new ArrayList<UserExcel>(){
            {
                add(new UserExcel("1","张三",18,"跳舞"));
                add(new UserExcel("2","李四",19,"唱歌"));
            }
        };
        ExportParams exportParams = new ExportParams();
        exportParams.setType(ExcelType.XSSF);
        exportParams.setSheetName("sheet1");

        Workbook sheets = ExcelExportUtil.exportExcel(exportParams,
                UserExcel.class, userExcels);

        BufferedOutputStream outputStream = FileUtil.getOutputStream(FileUtil.file("C:\\Users\\admin\\Desktop\\123.xlsx"));
        sheets.write(outputStream);
        outputStream.flush();
        outputStream.close();

        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名称
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode("home.xlsx", "UTF-8"));

        return FileUtil.readBytes(FileUtil.file("C:\\Users\\admin\\Desktop\\123.xlsx"));
    }
}
