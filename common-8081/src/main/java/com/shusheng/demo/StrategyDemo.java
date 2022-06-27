package com.shusheng.demo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2021/7/5.
 */
public class StrategyDemo {
    public static void main(String[] args) {
        String str = "[[{\"equipId\":\"NFM_ID\",\"equipName\":\"站内阀门\",\"equipType\":null},{\"equipId\":\"1217a10520fd4d2d97006926fe1eed52\",\"equipName\":\"阀门01\",\"equipType\":\"站内阀门\"}],[{\"equipId\":\"NFM_ID\",\"equipName\":\"站内阀门\",\"equipType\":null},{\"equipId\":\"7c8dadb4ef144142a16373709decf984\",\"equipName\":\"燃气站阀门\",\"equipType\":\"站内阀门\"}],[{\"equipId\":\"NFM_ID\",\"equipName\":\"站内阀门\",\"equipType\":null},{\"equipId\":\"a4d50c862f0d42aa92a38c42f952fd66\",\"equipName\":\"临时阀门\",\"equipType\":\"站内阀门\"}]]";

        List<List<EquipParsePo>> lists = JSONObject.parseObject(str, new TypeReference<List<List<EquipParsePo>>>() {
        });

        List<EquipParsePo> eps = new ArrayList<>();
        lists.forEach(eps::addAll);
        String collect = eps.stream().distinct().filter(x -> StringUtils.isNotBlank(x.getEquipType()))
                .map(EquipParsePo::getEquipName).collect(Collectors.joining(","));


        System.out.println("collect = " + collect);

    }

    @Data
    static class EquipParsePo {
        private String equipId;
        private String equipName;
        private String equipType;
    }

}
