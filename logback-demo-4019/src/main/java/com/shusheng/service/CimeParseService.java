package com.shusheng.service;

import java.io.File;
import java.util.List;

/**
 * @author 刘闯
 * @date 2022/8/6
 */
public interface CimeParseService {

    /**
     * 城市
     */
    String CITY = "新乡";

    /**
     * 获取开始标签
     * @return
     */
    String getBeginTag();

    /**
     * 获取结束标签
     * @return
     */
    String getEndTag();

    /**
     * 获取标题行以及注释
     * @return
     */
    <T> String getTitleLine(Class<T> cimeClass);

    /**
     * 将实体追加到Cime文件
     * @param file 文件
     * @param t 实体泛型
     */
    <T> void appendCimeFile(File file, List<T> t);
}
