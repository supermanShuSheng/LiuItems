package com.shusheng.demo;

import com.alibaba.fastjson.JSON;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

/**
  * @Desc XmlAnalysisUtil XML解析工具类
  * @author Mr.Bai
  * @DateTime 2021/12/4 0004 13:12
  * @version 1.0
  */
public class XmlAnalysisUtil {

    /**
     * XML解析成ListMap
     * @param xmlText xml文本
     * @return Map集合
     */
    public static List<Map<String,Object>> xmlAnalysisListMap(String xmlText){
        Document document = null;
        List<Map<String,Object>> resultList = new ArrayList<>();
        StringBuilder insertSql = new StringBuilder();
        insertSql.append("INSERT INTO `ywpz1_import_excel_sub_c`(`id`, `import_excel_id`, `dic_to_yn`, `update_where_yn`, `column_no`, `type`, `tree_rank`, `field_en_name`, `field_cn_name`, `field_type`, `field_join`, `create_time`, `update_time`, `disp_or`, `init_value`, `primary_key_yn`, `field_format`, `cal_type`, `sub_table`, `dic_parent_code`, `mandatory`, `sort_`, `null_abort`, `to_dic_field_name`, `diagram_field`, `update_cal_type`, `same_sub_table_name`) VALUES ");
        int column_no = 1;
        int disp_or = 7703;
        try{
            document = DocumentHelper.parseText(xmlText);
            Element rootElement = document.getRootElement();
            Iterator dataInfos = rootElement.elementIterator();
            while (dataInfos.hasNext()){
                Element recordEle = (Element) dataInfos.next();
                Iterator iterator = recordEle.elementIterator();
                Map<String,Object> map = new HashMap<>();
                while (iterator.hasNext()) {
                    Element next = (Element) iterator.next();
                    map.put(next.getName(), next.getText());
                    String remark = next.attributeValue("REMARK");
                    String name = next.getName();
                    if (!"SPECIALITYCODES".equals(name) && !remark.endsWith("（停）") && !"UUID".equals(name)){
                        insertSql.append("(");
                        insertSql.append(", 1042663331560, 'N', 'N', ").append(column_no).append(", 'EXCEL_FIELD', NULL, '").append(name).append("', '").append(remark).append("', '', '', '2021-12-24 09:30:16', '2021-12-24 09:30:16', ").append(disp_or).append(", '', 'N', '', '', '', '', 'N', NULL, 'N', NULL, '").append(name).append("', NULL, NULL");
                        insertSql.append("),");
                        column_no++;
                        disp_or++;
                    }
                }
                resultList.add(map);
            }
            insertSql.deleteCharAt(insertSql.lastIndexOf(","));
            insertSql.append(";");
        } catch (Exception e){
            System.out.println("异常");
        } finally {
            if (document != null) {
                document.clone();
            }
        }
        System.out.println(insertSql.toString());
        return resultList;
    }

    public static void main(String[] args) {
        String textValue = "<DATAINFOS>" +
                "      <DATAINFO>\n" +
                "      <UUID REMARK=\"UUID\">95947487D3784DD1ABBD2D0FE385E74F</UUID>\n" +
                "      <DESC1 REMARK=\"员工工号\">245813</DESC1>\n" +
                "      <DESC2 REMARK=\"姓名\">黄庆研</DESC2>\n" +
                "      <DESC3 REMARK=\"岗位序列编码\">Q</DESC3>\n" +
                "      <DESC4 REMARK=\"性别\">男</DESC4>\n" +
                "      <DESC5 REMARK=\"所属公司编码\">309</DESC5>\n" +
                "      <DESC6 REMARK=\"所属公司名称\">电极箔公司</DESC6>\n" +
                "      <DESC7 REMARK=\"经营单位编码\">A18</DESC7>\n" +
                "      <DESC8 REMARK=\"所属部门编码\">30000174</DESC8>\n" +
                "      <DESC9 REMARK=\"所属部门名称\">企管处</DESC9>\n" +
                "      <DESC10 REMARK=\"上级部门编码（停）\"/>\n" +
                "      <DESC11 REMARK=\"证件号码\">411421199407302812</DESC11>\n" +
                "      <DESC12 REMARK=\"手机\"/>\n" +
                "      <DESC13 REMARK=\"电话号码（停）\"/>\n" +
                "      <DESC14 REMARK=\"电子邮箱\"/>\n" +
                "      <DESC15 REMARK=\"岗位编码\">30000485</DESC15>\n" +
                "      <DESC16 REMARK=\"岗位名称\">应届毕业生</DESC16>\n" +
                "      <DESC17 REMARK=\"职务级别（停）\"/>\n" +
                "      <DESC18 REMARK=\"入职日期\">2021-12-06</DESC18>\n" +
                "      <DESC19 REMARK=\"离职日期\"/>\n" +
                "      <DESC20 REMARK=\"岗位序列\">其他</DESC20>\n" +
                "      <DESC21 REMARK=\"是否在岗\">Y</DESC21>\n" +
                "      <DESC22 REMARK=\"调离记录状态（停）\"/>\n" +
                "      <DESC23 REMARK=\"员工类别编码\">1</DESC23>\n" +
                "      <DESC24 REMARK=\"员工类别\">正式员工</DESC24>\n" +
                "      <DESC25 REMARK=\"开户银行\"/>\n" +
                "      <DESC26 REMARK=\"银行账号\"/>\n" +
                "      <DESC27 REMARK=\"联行号\"/>\n" +
                "      <DESC28 REMARK=\"所属组织终身码（停）\"/>\n" +
                "      <DESC29 REMARK=\"所属部门终身码（停）\"/>\n" +
                "      <DESC30 REMARK=\"国家/地区（停）\"/>\n" +
                "      <DESC31 REMARK=\"HR职务级别编码（停）\"/>\n" +
                "      <DESC32 REMARK=\"归属范围（停）\"/>\n" +
                "      <DESC33 REMARK=\"HR档案主键（停）\"/>\n" +
                "      <DESC34 REMARK=\"数据来源\">ZH</DESC34>\n" +
                "      <DESC35 REMARK=\"时间戳（停）\"/>\n" +
                "      <DESC36 REMARK=\"优先级别（停）\"/>\n" +
                "      <DESC37 REMARK=\"证件类型（停）\">身份证</DESC37>\n" +
                "      <DESC38 REMARK=\"经营单位名称\">新疆众和股份有限公司（集团）</DESC38>\n" +
                "      <DESC39 REMARK=\"上级部门名称（停）\"/>\n" +
                "      <DESC40 REMARK=\"职务指示\">主要职务</DESC40>\n" +
                "      <DESC41 REMARK=\"第一次入特变日期\">2021-12-06</DESC41>\n" +
                "      <DESC42 REMARK=\"汇报者岗位\">30000486</DESC42>\n" +
                "      <DESC43 REMARK=\"汇报者岗位名称\">处长</DESC43>\n" +
                "      <DESC44 REMARK=\"直接上级工号\">836838</DESC44>\n" +
                "      <DESC45 REMARK=\"直接上级名称\">王磊</DESC45>\n" +
                "      <DESC46 REMARK=\"数据新增/变更\">0</DESC46>\n" +
                "      <DESC47 REMARK=\"社会工龄起算日\">2021-08-18</DESC47>\n" +
                "      <DESC48 REMARK=\"工时制编号\"/>\n" +
                "      <DESC49 REMARK=\"工时制\"/>\n" +
                "      <DESC50 REMARK=\"民族编号\">HAN</DESC50>\n" +
                "      <DESC51 REMARK=\"民族\">汉族</DESC51>\n" +
                "      <DESC52 REMARK=\"出生日期\">1994-07-30</DESC52>\n" +
                "      <DESC53 REMARK=\"转正生效日期\">2022-03-06</DESC53>\n" +
                "      <DESC54 REMARK=\"岗位层级编号\">129</DESC54>\n" +
                "      <DESC55 REMARK=\"岗位层级\">一般员工</DESC55>\n" +
                "      <DESC56 REMARK=\"人才库标识\"/>\n" +
                "      <DESC57 REMARK=\"骨干员工标识\">N</DESC57>\n" +
                "      <DESC58 REMARK=\"日期预留1\"/>\n" +
                "      <DESC59 REMARK=\"日期预留2\"/>\n" +
                "      <DESC60 REMARK=\"日期预留3\"/>\n" +
                "      <DESC61 REMARK=\"政治面貌\"/>\n" +
                "      <DESC62 REMARK=\"职称\"/>\n" +
                "      <DESC63 REMARK=\"职业资格\"/>\n" +
                "      <DESC64 REMARK=\"文本预留4\"/>\n" +
                "      <DESC65 REMARK=\"文本预留5\"/>\n" +
                "      <DESC66 REMARK=\"文本预留6\"/>\n" +
                "      <DESC67 REMARK=\"文本预留7\"/>\n" +
                "      <DESC68 REMARK=\"预留字段8（停）\"/>\n" +
                "      <CODE REMARK=\"主编码\">245813</CODE>\n" +
                "      <SUBMITCORP REMARK=\"提报单位\">10000000</SUBMITCORP>\n" +
                "      <SPECIALITYCODES>\n" +
                "        <SPECIALITYCODE SPECIALITYNAME=\"银行信息\" CATEGORYCODE=\"\" SPECIALITYCODE=\"10002\">\n" +
                "          <PROPERTYCODE PROPERTYCODE=\"BANK\" STANDARDCODE=\"\" PROPERTYNAME=\"开户银行\" PREFIX=\"\" SUFFIX=\"\" BOUNDSYMBOL=\"\" UNIT=\"\"/>\n" +
                "          <PROPERTYCODE PROPERTYCODE=\"BANKACCOUNT\" STANDARDCODE=\"\" PROPERTYNAME=\"银行账号\" PREFIX=\"\" SUFFIX=\"\" BOUNDSYMBOL=\"\" UNIT=\"\"/>\n" +
                "          <PROPERTYCODE PROPERTYCODE=\"NBR\" STANDARDCODE=\"\" PROPERTYNAME=\"联行号\" PREFIX=\"\" SUFFIX=\"\" BOUNDSYMBOL=\"\" UNIT=\"\"/>\n" +
                "        </SPECIALITYCODE>\n" +
                "      </SPECIALITYCODES>\n" +
                "    </DATAINFO>" +
                "</DATAINFOS>";

        List<Map<String, Object>> maps = xmlAnalysisListMap(textValue);
        System.out.println(JSON.toJSONString(maps));
    }
}
