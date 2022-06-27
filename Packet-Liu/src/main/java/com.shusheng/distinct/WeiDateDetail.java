package com.shusheng.distinct;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2021/11/18.
 */
public class WeiDateDetail {
    public static void main(String[] args) throws SQLException, IOException {
        // 诊断日期
        String date = args==null||args.length==0?
                DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -2),"yyyy-MM-dd"):args[0];
        try{
            DateUtil.parse(date, "yyyy-MM-dd");
        }catch (Exception e){
            System.out.println(" 日期格式错误！格式为yyyy-MM-dd! 请重新运行该脚本！");
        }

        List<Entity> query = Db.use().query("SELECT * FROM diag_result c where c.data_date = '"+
                date+"' and c.errType in ('model_result', 'data_result')");

        Map<String, List<Entity>> diag_id = query.stream().collect(Collectors.groupingBy(x -> x.getStr("diag_id")));
        if (diag_id.size() == 0){
            System.out.println(" 未查到相应数据！ ");
        }

        List<DiagResult> dig = new ArrayList<>();

        diag_id.forEach((x,y)->{
            List<String> str = new ArrayList<>();
            y.forEach(z->{
                // 解析数据
                String diag_lable = z.getStr("diag_lable");
                // 取数据格式信息
                String type = StrUtil.equals(z.getStr("errType"), "data_result")?"数据诊断结果":"模型诊断结果";
                // 诊断结果
                List<JSONObject> modelResult = JSONUtil.toList(JSONUtil.parseObj(diag_lable).getStr(type), JSONObject.class);
                // 添加诊断
                if (modelResult != null && modelResult.size() > 0){
                    modelResult.forEach(q->{
                        List<String> diagnosis = JSONUtil.toList(q.getStr("诊断说明"), String.class);
                        str.addAll(diagnosis);
                    });
                }
            });
            if (str.size() > 0){
                // 整理数据
                Map<String, Long> disStr = str.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
                StringBuilder sb = new StringBuilder();
                disStr.forEach((e, f)->{
                    sb.append(e).append(" ").append(f).append("\n");
                });

                // 拿出其中一条公共数据信息
                Entity entity = y.get(0);
                DiagResult dr = new DiagResult();
                dr.setDevNo(entity.getStr("dev_no"));
                dr.setDevName(entity.getStr("dev_name"));
                dr.setOrgName(entity.getStr("org_name"));
                dr.setDataDate(entity.getStr("data_date"));
                dr.setDiagLable(sb.toString());
                dig.add(dr);
            }
        });

        // 数据打印日志
        System.out.println(" 扫描到 "+dig.size()+"组数据信息\n"+"正在导出文件 请勿关闭窗口！");

        // Excel导出
        ExportParams params = new ExportParams("诊断日志信息", "诊断信息", ExcelType.XSSF);
        // 指定单元格转换字典
        Workbook workbook = ExcelExportUtil.exportExcel(params, DiagResult.class, dig);

        // 写入文件
        BufferedOutputStream outputStream = FileUtil.getOutputStream(System.getProperty("user.dir")
                +"/"+"诊断日志.xlsx");
        workbook.write(outputStream);
        outputStream.close();
    }

    static class DiagResult{

        String diagId;

        @Excel(name = "线路编号", needMerge = true, width = 20)
        String devNo;
        @Excel(name = "线路名称", needMerge = true, width = 20)
        String devName;
        @Excel(name = "单位名称", needMerge = true, width = 20)
        String orgName;
        @Excel(name = "数据日期", needMerge = true, width = 20)
        String dataDate;
//        @Excel(name = "诊断类型", needMerge = true, width = 20)
        String errType;
        @Excel(name = "异常项", needMerge = true, width = 50)
        String diagLable;

        public DiagResult() {
        }

        public DiagResult(String diagId, String devNo, String devName, String orgName, String dataDate, String errType, String diagLable) {
            this.diagId = diagId;
            this.devNo = devNo;
            this.devName = devName;
            this.orgName = orgName;
            this.dataDate = dataDate;
            this.errType = errType;
            this.diagLable = diagLable;
        }

        @Override
        public String toString() {
            return "DiagResult{" +
                    "diagId='" + diagId + '\'' +
                    ", devNo='" + devNo + '\'' +
                    ", devName='" + devName + '\'' +
                    ", orgName='" + orgName + '\'' +
                    ", dataDate='" + dataDate + '\'' +
                    ", errType='" + errType + '\'' +
                    ", diagLable='" + diagLable + '\'' +
                    '}';
        }

        public String getDiagId() {
            return diagId;
        }

        public void setDiagId(String diagId) {
            this.diagId = diagId;
        }

        public String getDevNo() {
            return devNo;
        }

        public void setDevNo(String devNo) {
            this.devNo = devNo;
        }

        public String getDevName() {
            return devName;
        }

        public void setDevName(String devName) {
            this.devName = devName;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getDataDate() {
            return dataDate;
        }

        public void setDataDate(String dataDate) {
            this.dataDate = dataDate;
        }

        public String getErrType() {
            return errType;
        }

        public void setErrType(String errType) {
            this.errType = errType;
        }

        public String getDiagLable() {
            return diagLable;
        }

        public void setDiagLable(String diagLable) {
            this.diagLable = diagLable;
        }
    }
}
