package com.shusheng.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘闯
 * @date 2021/8/5.
 */
@Component
public class StrategyP {

    public final Map<String, P> p = new HashMap<>();

    public StrategyP(List<P> pList) {
        for (P po : pList) {
            Service annotation = po.getClass().getAnnotation(Service.class);
            p.put(annotation.value(), po);
        }
    }

    public P getP(String type){
        return this.p.get(type);
    }
}
