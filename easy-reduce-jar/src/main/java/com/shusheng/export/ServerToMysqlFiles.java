package com.shusheng.export;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.StrUtil;

/**
 * @author 刘闯
 * @date 2022/8/2
 */
public class ServerToMysqlFiles {

    public static final String FILE_PATH = "/home/data_change/job/sql_server_to_mysql_curv.json";

    public static void main(String[] args) {
        DateTime date = DateUtil.date();
        //构建定时任务日期
        DateTime begin = DateUtil.offsetDay(date, -2);
        DateTime end = DateUtil.offsetDay(date, -1);

        System.out.println("开始日期："+begin+",结束日期："+end);
        String filesContent = buildChangeFiles(DateUtil.format(begin, "yyyy-MM-dd"), DateUtil.format(end, "yyyy-MM-dd"));

        // 覆盖文件内容
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        System.out.println("开始写入文件内容===>");
        fileWriter.write(filesContent);
        System.out.println("===写入成功===");
    }

    private static String buildChangeFiles(String beginDate, String endDate){
        String begin = "{\n" +
                "    \"job\": {\n" +
                "        \"setting\": {\n" +
                "            \"speed\": {\n" +
                "                \"channel\": 20\n" +
                "            }\n" +
                "        },\n" +
                "        \"content\": [\n" +
                "            {\n" +
                "                \"reader\": {\n" +
                "                    \"name\": \"sqlserverreader\",\n" +
                "                    \"parameter\": {\n" +
                "                        \"username\": \"dl\",\n" +
                "                        \"password\": \"ssdl168\",\n" +
                "                        \"column\": [\"Id\",\"MeterId\",\"ValueTime\",\"SaveTime\",\"Zy\",\"Fy\",\"Zw\",\"Fw\",\"Ua\",\"Ub\",\"Uc\",\"Ia\",\"Ib\",\"Ic\",\"I0\",\"Pz\",\"Pa\",\"Pb\",\"Pc\",\"Qz\",\"Qa\",\"Qb\",\"Qc\",\"Pfz\",\"Pfa\",\"Pfb\",\"Pfc\"],\n";

        String end = "                        \"connection\": [\n" +
                "                            {\n" +
                "                                \"table\": [\"MeterCurv\"],\n" +
                "                                \"jdbcUrl\": [\"jdbc:sqlserver://10.160.85.200:11433;databaseName=emms;autoReconnect=true\"]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                },\n" +
                "                \"writer\": {\n" +
                "                    \"name\": \"mysqlwriter\",\n" +
                "                    \"parameter\": {\n" +
                "                        \"username\": \"root\",\n" +
                "                        \"password\": \"DLgd1234\",\n" +
                "                        \"writeMode\": \"insert\",\n" +
                "                        \"column\": [\"Id\",\"MeterId\",\"ValueTime\",\"SaveTime\",\"Zy\",\"Fy\",\"Zw\",\"Fw\",\"Ua\",\"Ub\",\"Uc\",\"Ia\",\"Ib\",\"Ic\",\"I0\",\"Pz\",\"Pa\",\"Pb\",\"Pc\",\"Qz\",\"Qa\",\"Qb\",\"Qc\",\"Pfz\",\"Pfa\",\"Pfb\",\"Pfc\"],\n" +
                "                        \"session\": [],\n" +
                "                        \"preSql\": [],\n" +
                "                        \"connection\": [\n" +
                "                            {\n" +
                "                                \"jdbcUrl\": \"jdbc:mysql://10.161.33.75:3306/gz_sys_db\",\n" +
                "                                \"table\": [\"MeterCurv\"]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n";


        String center = StrUtil.format("                        \"where\": \"ValueTime > '{}' and ValueTime <= '{}'\",\n", beginDate, endDate);

        return begin + center + end;
    }
}
