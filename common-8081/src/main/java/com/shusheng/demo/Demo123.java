package com.shusheng.demo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.lang.Opt;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2021/6/16.
 */
public class Demo123 {
    public static void main(String[] args) throws InterruptedException, IOException {
        String str = "";



    }

    /**
     * temp = 5
     * a[0] = 2
     */

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Po{
        /**
         * 计算日期
         */
        private Date statDate;

        /**
         * 计算日期
         */
        private Double abc;

        private List<Double> hh;
    }


    public static void saveFiles(){
        File file = FileUtil.touch("C:\\Users\\admin\\Desktop\\" + IdUtil.simpleUUID() + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            JSONObject js = new JSONObject();
            js.put("123", "abc");
            js.put("qwe", "456");
            String str = "loss|" + js.toJSONString()+"\n";

            fileWriter.append(str);
        });

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(() -> {
            JSONObject js1 = new JSONObject();
            js1.put("hahaa", "poiwuer");
            js1.put("dsfmisdjofs", "4e1we56f1sd2fe56");
            String str1 = "record|" + js1.toJSONString()+"\n";

            fileWriter.append(str1);

        });

        JSONObject js2 = new JSONObject();
        js2.put("sdfewrwe", "acvxcbc");
        js2.put("168df4gfgdf", "werw");
        String str2 = "loss2|" + js2.toJSONString()+"\n";


        fileWriter.append(str2);

    }



    public static <T> void pare123(T t){
        String s = JSONObject.toJSONString(t, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullNumberAsZero);
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println("jsonObject = " + jsonObject);

    }
    public static <T> Object pare(T t){


        System.out.println("t = " + t);

        if (t instanceof String){
            System.out.println(" 11111 ");
        }

        if (t instanceof JSONObject){
            JSONObject a = (JSONObject) t;
            System.out.println("a.getString(\"pageSize\") = " + a.getString("pageSize"));
            System.out.println(" 22222 ");
        }

        if (t instanceof HashMap){
            HashMap a = (HashMap) t;
            System.out.println("a   .get(\"pageSize\") = " + a.get("pageSize"));
        }

        try {
            String pageSize = t.getClass().getField("pageSize").getName();

            return pageSize;
        } catch (NoSuchFieldException e) {
            System.out.println("e = " + e);
        }
        return "23";
    }

    /**
     * XML解析成ListMap
     * @param xmlText xml文本
     * @return Map集合
     */
    public static List<Map<String,Object>> xmlAnalysisListMap(String xmlText){
        Document document = null;
        List<Map<String,Object>> resultList = new ArrayList<>();
        StringBuffer insertSql = new StringBuffer();
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
                        insertSql.append(UUID.randomUUID()).append(", 1042663331560, 'N', 'N', ").append(column_no).append(", 'EXCEL_FIELD', NULL, '").append(name).append("', '").append(remark).append("', '', '', '2021-12-24 09:30:16', '2021-12-24 09:30:16', ").append(disp_or).append(", '', 'N', '', '', '', '', 'N', NULL, 'N', NULL, '").append(name).append("', NULL, NULL");
                        insertSql.append("),");
                        column_no++;
                        disp_or++;
                    }
                }
                resultList.add(map);
            }
            insertSql.deleteCharAt(insertSql.lastIndexOf(","));
            insertSql.append(";");
        }catch (Exception e){
            System.out.println(" 异常 ");
        }
        return resultList;
    }

    public static void aaaaa(){
        String str = "GHGHGG";

        Long num = 0L;
        for (int i = 0; i < str.length()-2; i ++){
            List<Character> abc = new ArrayList<>();
            abc.add(str.charAt(i));
            abc.add(str.charAt(i+1));
            for(int j = i+2; j < str.length(); j ++){
                abc.add(str.charAt(j));
                boolean b = true;
                for (Map.Entry<Character, Long> entry : abc.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet()) {
                    if (entry.getValue() == 1){
                        num ++;
                        b = false;
                        break;
                    }
                }
                // 终止条件
                if (b){
                    break;
                }
            }
        }
        System.out.println("num = " + num);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListSort {
        private String id;
        private String id2;
        private Double number;
    }


    @Data
    public static class SubInfo {
        /**
         * 变电站ID
         */
        private String subsId;
        /**
         * 经度
         */
        private String longitude;
        /**
         * 维度
         */
        private String latitude;
        /**
         * 变电站名称
         */
        private String subsName;

//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            SubInfo subInfo = (SubInfo) o;
//            return Objects.equals(longitude, subInfo.longitude) &&
//                    Objects.equals(latitude, subInfo.latitude);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(longitude, latitude);
//        }
    }

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
        final Integer DPI = 300;

        /**
         * 转换后的图片类型
         */
        final String IMG_TYPE = "png";

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

// cbcdcbedcbc

//解答失败: 测试用例:"cbcdcbedcbc" 测试结果:"cbc" 期望结果:"bcdcb" stdout: