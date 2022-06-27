package com.shusheng.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.shusheng.entity.*;
import com.shusheng.mapper.DeploymentFlowMapper;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘闯
 * @date 2022/6/17
 */
@RestController
@RequestMapping("/task")
public class TaskFlowController {

    @Autowired
    DeploymentFlowMapper deploymentFlowMapper;

    /**
     *  创建实例部署
     * @param repositoryFlowEntity
     */
    @PostMapping("/activitiEvection")
    public void testActivitiEvection(@RequestBody RepositoryFlowEntity repositoryFlowEntity){
        // 流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 资源管理类
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 创建一个流程
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment()
                .name(repositoryFlowEntity.getName());
        for (String resourcePath : repositoryFlowEntity.getResourcePaths()) {
            deploymentBuilder.addClasspathResource(resourcePath);
        }
        // 创建实例
        Deployment deploy = deploymentBuilder.deploy();

        // 输出流程部署信息
        System.out.println("流程部署ID:"+deploy.getId());
        System.out.println("流程部署名称:"+deploy.getName());

        // 流程暂停和流程启动

        //        得到当前流程定义的实例是否都为暂停状态
/*        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("EvectionFlow")
                .singleResult();

        boolean suspended = processDefinition.isSuspended();
//        流程定义id
        String processDefinitionId = processDefinition.getId();
//        判断是否为暂停
        if(suspended){
//         如果是暂停，可以执行激活操作 ,参数1 ：流程定义id ，参数2：是否激活，参数3：激活时间
            repositoryService.activateProcessDefinitionById(processDefinitionId,
                    true,
                    null
            );
            System.out.println("流程定义："+processDefinitionId+",已激活");
        }else{
//          如果是激活状态，可以暂停，参数1 ：流程定义id ，参数2：是否暂停，参数3：暂停时间
            repositoryService.suspendProcessDefinitionById(processDefinitionId,
                    true,
                    null);
            System.out.println("流程定义："+processDefinitionId+",已挂起");
        }*/
    }


    /**
     *  更新已部署实例
     * @param repositoryFlowEntity
     */
    @PostMapping("/updateActivitiEvection")
    public String updateActivitiEvection(@RequestBody RepositoryFlowEntity repositoryFlowEntity){
        String path = this.getClass().getClassLoader().getResource(repositoryFlowEntity.getResourceBytes())
                .getPath();

        deploymentFlowMapper.updateDeployGeBytearray(FileUtil.readBytes(path), repositoryFlowEntity.getBytearrayId());
        // 更新成功
        return "更新成功！";
    }

    /**
     * 启动实例流程
     * @param runFlowEntity
     */
    @PostMapping("/startEvectionFlow")
    public String testStartEvectionFlow(@RequestBody RunFlowEntity runFlowEntity){
        // 流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程启动类
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 创建数据字典
        Map<String, Object> dataMap = runFlowEntity.getDataMap();
        EvectionEntity evectionEntity = new EvectionEntity();
        evectionEntity.setNum(5.0);
        dataMap.put("evection", evectionEntity);

        // 启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
                runFlowEntity.getDefineKey(),
                runFlowEntity.getBusinessKey(),
                dataMap
        );
        System.out.println("启动实例成功\n" +
                "实例ID为："+processInstance.getId());

        return "启动实例成功\n" +
                "实例ID为："+processInstance.getId();

    /*
        ProcessInstance evectionFlow = runtimeService.startProcessInstanceByKey("EvectionFlow");
        // 输出
        System.out.println("流程定义ID：" + evectionFlow.getProcessDefinitionId());
        System.out.println("流程实例ID：" + evectionFlow.getId());
        System.out.println("当前活动ID：" + evectionFlow.getActivityId());

        // 启动流程并增加与实际业务相关的KEY
        ProcessInstance evectionFlow1 = runtimeService.startProcessInstanceByKey("EvectionFlow", "1005");

        System.out.println("实际业务ID："+evectionFlow1.getBusinessKey());

        // 启动流程 增加关联业务流程ID和实例变量
        HashMap<String, Object> strMap = new HashMap<>();
        strMap.put("assignee0", "张三");
        strMap.put("assignee1", "李四");
        runtimeService.startProcessInstanceByKey("EvectionFlow","1005",
                                        strMap);


        // 流程实例暂停
        //        得到当前流程定义的实例是否都为暂停状态
        ProcessInstance evectionFlow2 = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey("EvectionFlow")
                .processInstanceBusinessKey("1005")
                .singleResult();

        boolean suspended = evectionFlow2.isSuspended();
//        流程定义id
        String processDefinitionId = evectionFlow2.getId();
//        判断是否为暂停
        if(suspended){
//         如果是暂停，可以执行激活操作 ,参数：流程定义id
            runtimeService.activateProcessInstanceById(processDefinitionId);
            System.out.println("流程定义："+processDefinitionId+",已激活");
        }else{
//          如果是激活状态，可以暂停，参数：流程定义id
            runtimeService.suspendProcessInstanceById( processDefinitionId);
            System.out.println("流程定义："+processDefinitionId+",已挂起");
        }*/
    }

    /**
     * 查询个人待执行的任务
     */
    @PostMapping("/findTaskList")
    public Map<String, String> testFindTaskList(@RequestBody TaskFlowEntity taskFlowEntity){
        // 默认登录
//        LoginVailUtils.initSecurity();

        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 任务
        TaskService taskService = defaultProcessEngine.getTaskService();
        // 查询流程信息
        // 查询对应流程Key和负责人的任务
        TaskQuery taskQuery = taskService.createTaskQuery()
                .processDefinitionKey(taskFlowEntity.getDefineKey())
                .processInstanceId(taskFlowEntity.getInstanceId())
                .processInstanceBusinessKey(taskFlowEntity.getBusinessKey());

        // 如果名称为空 报错
        if (StrUtil.isNotBlank(taskFlowEntity.getAssignee())){
            // 查询名称或则候选者
            taskQuery.taskCandidateOrAssigned(taskFlowEntity.getAssignee());
        }
        List<Task> list = taskQuery.list();

        Map<String, String> resultMap = new HashMap<>();

        for (Task task : list) {
            resultMap.put("流程实例ID：", task.getProcessDefinitionId());
            resultMap.put("实例ID：", task.getProcessInstanceId());
            resultMap.put("任务ID：", task.getId());
            resultMap.put("任务负责人：", task.getAssignee());
            resultMap.put("任务名称：", task.getName());
            System.out.println("流程实例ID："+task.getProcessDefinitionId());
            System.out.println("实例ID："+task.getProcessInstanceId());
            System.out.println("任务ID："+task.getId());
            System.out.println("任务负责人："+task.getAssignee());
            System.out.println("任务名称："+task.getName());
        }

        return resultMap;
    }


    /**
     * 完成个人任务
     */
    @PostMapping("/completeTask")
    public String testCompleteTest(@RequestBody CompleteTaskEntity completeTaskEntity){
        // 流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程启动类
        TaskService taskService = processEngine.getTaskService();

        // 找到任务
        TaskQuery taskQuery = taskService.createTaskQuery()
                .processInstanceId(completeTaskEntity.getInstanceId())
                .processInstanceBusinessKey(completeTaskEntity.getBusinessKey());

        if (StrUtil.isNotBlank(completeTaskEntity.getUserName())){
            taskQuery.taskCandidateOrAssigned(completeTaskEntity.getUserName());
        }

        Task task = taskQuery.singleResult();

        // 获取任务的执行人
        String assignee = task.getAssignee();

        if (StrUtil.equals(assignee, completeTaskEntity.getUserName())){
            // 修改下一流程的变量
//            Map<String, Object> tempMap = new HashMap<>();
//            tempMap.put("assignee0", "chuang0");
//            tempMap.put("assignee1", "chuang1");
            // 完成任务并修改变量
//            taskService.complete(task.getId(), tempMap, true);
            taskService.complete(task.getId());
            return "完成任务！";
        }

        return "权限不足！";
    }

    /**
     * 给任务指定候选人
     */
    @PostMapping("/claimTask")
    public String claimTask(@RequestBody ClaimTaskEntity claimTaskEntity){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        // 查找当前任务的流程实例
        Task task = taskService.createTaskQuery()
                .processInstanceId(claimTaskEntity.getInstanceId())
                .singleResult();


        List<IdentityLink> identityLinksForTask = taskService.getIdentityLinksForTask(task.getId());
        // 查询候选人列表
        String userId = identityLinksForTask.get(0).getUserId();

        // 接收任务
        taskService.claim(task.getId(), userId);

        return userId+"接单成功！";
    }

    /**
     * 退回任务给组
     */
    @PostMapping("/unClaimTask")
    public String unClaimTask(@RequestBody ClaimTaskEntity claimTaskEntity){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        // 查找当前任务的流程实例
        Task task = taskService.createTaskQuery()
                .processInstanceId(claimTaskEntity.getInstanceId())
                .singleResult();

        taskService.unclaim(task.getId());

        return task.getId()+"退回成功！";
    }

    /**
     * 委托给别人去做
     */
    @PostMapping("/delegateTask")
    public String delegateTask(@RequestBody ClaimTaskEntity claimTaskEntity){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        // 查找当前任务的流程实例
        Task task = taskService.createTaskQuery()
                .processInstanceId(claimTaskEntity.getInstanceId())
                .singleResult();

        // 委托给别人去做  这里最好进行校验
        taskService.delegateTask(task.getId(), "haha5");

        return task.getId()+"委托成功！";
    }


    /**
     * 完成个人任务
     */
    @GetMapping("/autoCompleteTask/{defindId}")
    public void autoCompleteTask(@PathVariable String defindId){
        // 流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程启动类
        TaskService taskService = processEngine.getTaskService();

        List<Task> list = taskService.createTaskQuery()
                .processDefinitionId(defindId)
                .list();

//        Task task = taskService.createTaskQuery()
//                .processDefinitionId(defindId)
//                .singleResult();

        System.out.println();
        // 完成任务
//        taskService.complete(task.getId());
    }

    /**
     * 查询当前实例运行信息
     * @param curveRunEntity
     * @return
     */
    @PostMapping("/curveRunInfo")
    public String curveRunInfo(@RequestBody CurveRunEntity curveRunEntity){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(curveRunEntity.getInstanceId())
                .orderByHistoricActivityInstanceStartTime()
                .asc()
//                .unfinished() // 未完成的活动(任务)
                .list();

        for (HistoricActivityInstance historicActivityInstance : list) {
            System.out.printf("实例ID：%s\n" +
                    "步骤名称：%s\n" + "结点类型：%s\n" +
                            "审核人：%s\n" +
                            "任务开始时间：%s\n" +
                            "任务结束时间：%s\n" +
                            "=============================================================================\n",
                    historicActivityInstance.getActivityId(),
                    historicActivityInstance.getActivityName(),
                    historicActivityInstance.getActivityType(),
                    historicActivityInstance.getAssignee(),
                    historicActivityInstance.getStartTime(),
                    historicActivityInstance.getEndTime());
        }
        return "查询成功！";
    }

    /**
     * 查询当前流程图
     * @param instanceId
     * @return
     */
    @GetMapping("/getMapByInstinct")
    public void getMapByInstinct(@RequestParam(value = "instanceId") String instanceId,
                                 @RequestParam(value = "scaleFactor", defaultValue = "1.0d") Double scaleFactor,
                                 HttpServletResponse response) throws IOException {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        ProcessInstance processInstance = processEngine.getRuntimeService()
                .createProcessInstanceQuery()
                .processInstanceId(instanceId)
                .singleResult();

        List<Task> list = processEngine.getTaskService()
                .createTaskQuery()
                .processInstanceId(instanceId)
                .list();

        List<String> activeActivityIds = new ArrayList<>();

        for (Task task : list) {
            List<String> act = processEngine.getRuntimeService()
                    .getActiveActivityIds(task.getExecutionId());

            activeActivityIds.addAll(act);
        }

        // 流程定义
        BpmnModel bpmnModel = processEngine.getRepositoryService()
                .getBpmnModel(processInstance.getProcessDefinitionId());

        ProcessDiagramGenerator ge = new DefaultProcessDiagramGenerator();
        InputStream imageStream = ge.generateDiagram(
                bpmnModel,
                activeActivityIds, // 高亮的节点
                new ArrayList<>(),
                "宋体",
                "宋体",
                "宋体"
            );

        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }

}
