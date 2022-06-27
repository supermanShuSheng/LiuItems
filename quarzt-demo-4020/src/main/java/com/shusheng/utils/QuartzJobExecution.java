package com.shusheng.utils;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.shusheng.entity.SysJob;
import org.quartz.JobExecutionContext;

/**
 * @author 刘闯
 * @date 2022/5/24
 */
public class QuartzJobExecution extends AbstractQuartzJob {


    /**
     * 执行任务
     * @param context 工作执行上下文对象
     * @param sysJob 系统计划任务
     */
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) {
        String invokeTarget = sysJob.getInvokeTarget();
        String beanName = getBeanName(invokeTarget);
        String methodName = getMethodName(invokeTarget);
        JSONObject jsonObject = getMethodParams(invokeTarget);

        Object bean = null;
        // 通过实例名找实例对象
        if (!isValidClassName(beanName)) {
            bean = ApplicationBeanUtils.getBean(beanName);
        } else {
            try {
                bean = Class.forName(beanName).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ReflectUtil.invoke(bean, methodName, jsonObject);
    }

    /**
     * 获取执行参数
     * @param invokeTarget 表达式
     * @return 执行方法
     */
    private JSONObject getMethodParams(String invokeTarget) {
        String params = StrUtil.subBetween(invokeTarget, "(", ")");
        if (StrUtil.isBlank(params)){
            return new JSONObject();
        }

        return JSONUtil.parseObj(params);
    }

    /**
     * 获取方法名称
     * @param invokeTarget 表达式
     * @return bean
     */
    private String getMethodName(String invokeTarget) {
        // 找到左括号前的字符串
        String beanName = StrUtil.subBefore(invokeTarget, "(", false);
        // 找到最后一个.之后的字符串
        return StrUtil.subAfter(beanName, ".", true);
    }

    /**
     * 获取注入Bean名称
     * @param invokeTarget 表达式
     * @return bean
     */
    private String getBeanName(String invokeTarget) {
        // 找到左括号前的字符串
        String beanName = StrUtil.subBefore(invokeTarget, "(", false);
        // 找到最后一个.之前的字符串
        return StrUtil.subBefore(beanName, ".", true);
    }

    /**
     * 校验是否为为class包名
     *
     * @param beanName 名称
     * @return true是 false否
     */
    public static boolean isValidClassName(String beanName) {
        // 统计.出现的次数
        return StrUtil.count(beanName, ".") > 1;
    }


}
