package com.shusheng;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.zip.ZipInputStream;

/**
 * @author 刘闯
 * @date 2022/6/17
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
class Workflow_Activiti_4021Test {


    /**
     * 通过ZIP的方式进行部署
     */
    @Test
    public void zipUploadTest(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        ZipInputStream zipInputStream = new ZipInputStream(
                Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("processes/processes.zip"))
        );
        // 流程部署
        Deployment deploy = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .deploy();
    }

    /**
     * 获取流程定义
     */
    @Test
    public void getDeploymentDefineTest(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        List<ProcessDefinition> evectionFlow = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("EvectionFlow")
                .orderByProcessDefinitionVersion()
                .desc()
                .list();

        for (ProcessDefinition processDefinition : evectionFlow) {
            System.out.println("名称："+processDefinition.getName());
            System.out.println("Key:"+processDefinition.getKey());
        }
    }

}