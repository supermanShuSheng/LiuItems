package com.shusheng.serviceImpl;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.StrUtil;
import com.shusheng.service.CimeParseService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author 刘闯
 * @date 2022/8/6
 */
@Service("voltageLevel")
public class BaseVoltageServiceImpl implements CimeParseService {

    @Override
    public String getBeginTag() {
        return StrUtil.format("<BaseVoltage::{}>", CITY);
    }

    @Override
    public String getEndTag() {
        return StrUtil.format("</BaseVoltage::{}>", CITY);
    }

    @Override
    public <T> String getTitleLine(Class<T> cimeClass) {

        return null;
    }

    /**
     * 将实体追加到Cime文件
     * @param file 文件
     * @param t 实体泛型
     */
    @Override
    public <T> void appendCimeFile(File file, List<T> t) {
        FileWriter fileWriter = FileWriter.create(file);

    }
}
