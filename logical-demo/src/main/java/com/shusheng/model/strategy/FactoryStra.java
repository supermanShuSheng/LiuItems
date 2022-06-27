package com.shusheng.model.strategy;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 策略+工厂
 * @author 刘闯
 * @date 2021/7/19.
 */
public class FactoryStra {

    @Resource
    @Qualifier("p1")
    private P p1;

    @Resource
    @Qualifier("p2")
    private P p2;

    private Map<String, P> map = new HashMap<>();

    public FactoryStra() {
        map.put("p1", p1);
        map.put("p2", p2);
    }

    public P getFactory(String type) {
        if (map.get(type) == null) {
            throw new RuntimeException("策略为空！");
        }
        return map.get(type);
    }
}
