package com.shusheng.demo;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.shusheng.domain.excel.DeptEntity;
import com.shusheng.domain.excel.OrgEntity;
import com.shusheng.mapper.OrgMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2021/7/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    OrgMapper orgMapper;

    @Autowired
    StrategyP strategyP;

    @Test
    @Transactional
    @Rollback(false)
    public void getOrg() throws Exception {
        List<OrgEntity> list = ExcelImportUtil.importExcel(
                new FileInputStream("C:\\Users\\admin\\Desktop\\附件一：单位部门组织架构 (1).xlsx"),
                OrgEntity.class, new ImportParams());
        List<OrgEntity> orgEntity = list.stream().filter(x -> StringUtils.isNotEmpty(x.getOrgNameList())).collect(Collectors.toList());

        for (OrgEntity entity : orgEntity) {
            int blag = orgMapper.updateOrg(entity);
            System.out.println("是否成功 = " + blag);
        }
//        TransactionAspectSupport.currentTransactionStatus().isCompleted();
    }

    @Test
    @Transactional
    @Rollback(false)
    public void getDept() throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(1);

        List<DeptEntity> list = ExcelImportUtil.importExcel(
                new FileInputStream("C:\\Users\\admin\\Desktop\\附件一：单位部门组织架构 (1).xlsx"),
                DeptEntity.class, importParams);


        System.out.println("list = " + list);

        System.out.println("list.size() = " + list.size());


        for (DeptEntity entity : list) {
            int blag = orgMapper.updateDept(entity);
            System.out.println("是否成功 = " + blag);
        }
    }


    @Test
    public void getP(){
        P p1 = strategyP.getP("p2");
        System.out.println("p1 = " + p1);
        System.out.println("p1.sayHear() = " + p1.sayHear());
        System.out.println(p1.sayHello());
    }
}
