package com.shusheng;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘闯
 * @date 2021/9/18.
 */
public class WorkReplace {

    @Test
    public void testOne() throws IOException, TemplateException {
        // 要填充的数据, 注意map的key要和word中${xxx}的xxx一致
        Map<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("username", "张三");
        dataMap.put("sex", "男");

        //Configuration用于读取ftl文件
        Configuration configuration = new Configuration(new Version("2.3.31"));
        configuration.setDefaultEncoding("utf-8");

        /*以下是两种指定ftl文件所在目录路径的方式, 注意这两种方式都是
         * 指定ftl文件所在目录的路径,而不是ftl文件的路径
         */
        //指定路径的第一种方式(根据某个类的相对路径指定)
        //configuration.setClassForTemplateLoading(this.getClass(),"");

        //指定路径的第二种方式,我的路径是C:/a.ftl
        configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\admin\\Desktop"));


        // 输出文档路径及名称
        File outFile = new File("C:\\Users\\admin\\Desktop\\test.doc");

        //以utf-8的编码读取ftl文件
        Template t =  configuration.getTemplate("abc.ftl","utf-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), StandardCharsets.UTF_8),10240);
        t.process(dataMap, out);
        out.close();
    }
}
