package com.shusheng.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.shusheng.commons.CimeNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author 刘闯
 * @date 2022/8/6
 */
public class CimeBeanUtils {

    /**
     * 获取Bean遍历获取到的Buff集合
     * @param cimeClass
     * @return
     */
    public static <T> String getCimeBeanBuff(Class<T> cimeClass){
        StringBuilder name = new StringBuilder("@");
        StringBuilder node = new StringBuilder("//");
        // 遍历Bean
        BeanUtil.descForEach(cimeClass, propDesc -> {
            String fieldName = propDesc.getFieldName();
            String fieldNode = propDesc.getField().getAnnotation(CimeNode.class).value();

            name.append(fieldName).append("\t");
            node.append(fieldNode).append("\t");
        });


        return StrUtil.format("{}\n{}\n", name, node);
    }

    /**
     * 将数据追加到cime文件
     * @param cimeList
     *
     */
    public static <T> void appendListCime(FileWriter fileWriter, List<T> cimeList) {
        for (T cimeEntity : cimeList) {
            // 获取数据组合值
            String cimeValue = getCimeValue(cimeEntity);
            // 追加到文件
            fileWriter.append(cimeValue);
        }
    }

    /**
     * 流的方式加锁添加
     * @param fileOutputStream
     * @param cimeList
     * @param <T>
     */
    public static <T> void appendListCime(FileOutputStream fileOutputStream, List<T> cimeList) {
        for (T cimeEntity : cimeList) {
            // 获取数据组合值
            String cimeValue = getCimeValue(cimeEntity);
            // 追加到文件
            try {
                fileOutputStream.write(cimeValue.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将数据追加到cime文件
     * @param file
     * @param cimeList
     * @param <T>
     */
    public static <T> void appendListCime(File file, List<T> cimeList){
        appendListCime(FileWriter.create(file), cimeList);
    }


    /**
     * 遍历一个对象的所有Bean属性
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String getCimeValue(T t){
        StringBuilder fieldValue = new StringBuilder("#\t");

        // 开始遍历
        Field[] fields = ReflectUtil.getFields(t.getClass());
        for (Field field : fields) {
            String fieldStr = String.valueOf(ReflectUtil.getFieldValue(t, field));
            // 如果为null转化为大写的
            if (StrUtil.equals(fieldStr, "null")){
                fieldStr = fieldStr.toUpperCase();
            }
            fieldValue.append(fieldStr).append("\t");
        }

        return String.valueOf(fieldValue.append("\n"));
    }
}
