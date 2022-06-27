package com.shusheng.strategy;

import com.shusheng.service.TestStrategyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试策略模式
 * @author 刘闯
 * @date 2021/7/5.
 */
@Component
public class TestStrategy {

    private final Map<String, TestStrategyService> serviceMap = new HashMap<>();

    public TestStrategy(List<TestStrategyService> serviceList){
        for (TestStrategyService service : serviceList) {
            Service annotation = service.getClass().getAnnotation(Service.class);
            serviceMap.put(annotation.value(), service);
        }
    }

    public TestStrategyService getImplByType(String type){
        if (StringUtils.isEmpty(type)){
            throw new RuntimeException("参数异常");
        }
        return serviceMap.get(type);
    }
}
