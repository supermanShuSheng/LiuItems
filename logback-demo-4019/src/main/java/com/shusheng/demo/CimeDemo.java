package com.shusheng.demo;

import cn.hutool.core.io.FileUtil;
import com.shusheng.cime.BaseVoltageEntity;
import com.shusheng.serviceImpl.BaseVoltageServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2022/8/6
 */
public class CimeDemo {
    public static void main(String[] args) {
        BaseVoltageServiceImpl baseVoltageService = new BaseVoltageServiceImpl();

        List<BaseVoltageEntity> baseVoltageEntities = new ArrayList<>();
        BaseVoltageEntity b1 = new BaseVoltageEntity();
        BaseVoltageEntity b2 = new BaseVoltageEntity();

        b1.setMRID("123");
        b1.setRegion_id("123");
        b2.setName("liu");
        b2.setNomkV("kkk");
        baseVoltageEntities.add(b1);
        baseVoltageEntities.add(b2);

        new Thread(() -> {
            baseVoltageService.appendCimeFile(FileUtil.file("C:\\Users\\admin\\Desktop\\线损URL1.CIME"), baseVoltageEntities);
        }).start();

        new Thread(() -> {
            baseVoltageService.appendCimeFile(FileUtil.file("C:\\Users\\admin\\Desktop\\线损URL1.CIME"), baseVoltageEntities);
        }).start();

        new Thread(() -> {
            baseVoltageService.appendCimeFile(FileUtil.file("C:\\Users\\admin\\Desktop\\线损URL1.CIME"), baseVoltageEntities);
        }).start();
    }
}
