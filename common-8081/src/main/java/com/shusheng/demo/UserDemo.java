package com.shusheng.demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.shusheng.commons.R;
import com.shusheng.domain.Do.UserDo;
import com.shusheng.domain.Vo.Father;
import com.shusheng.utils.RedisUtils;
import com.shusheng.utils.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2021/3/19.
 */


@Component
public class UserDemo {

    private final RedisUtils redisUtils;

    public UserDemo(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Test
    public void main() {
        Father father = new Father();
        father.setAge(18);
        System.out.println("father.toString() = " + father);
    }

    @Test
    public void huTools(){
        String str  = "[\n" +
                "    {\n" +
                "        \"MAIN_SUB_NET\":\"主网\",\n" +
                "        \"NAME\":\"峨眉公司\",\n" +
                "        \"BEGIN_TIME\":\"202102\",\n" +
                "        \"END_TIME\":\"202105\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"MAIN_SUB_NET\":\"配网\",\n" +
                "        \"NAME\":\"峨眉公司\",\n" +
                "        \"BEGIN_TIME\":\"202103\",\n" +
                "        \"END_TIME\":\"202106\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"MAIN_SUB_NET\":\"主网\",\n" +
                "        \"NAME\":\"夹江公司\",\n" +
                "        \"BEGIN_TIME\":\"202101\",\n" +
                "        \"END_TIME\":\"202105\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"MAIN_SUB_NET\":\"主网\",\n" +
                "        \"NAME\":\"夹江公司\",\n" +
                "        \"BEGIN_TIME\":\"202104\",\n" +
                "        \"END_TIME\":\"202110\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"MAIN_SUB_NET\":\"主网\",\n" +
                "        \"NAME\":\"乐山电力有限股份公司\",\n" +
                "        \"BEGIN_TIME\":\"202102\",\n" +
                "        \"END_TIME\":\"202108\"\n" +
                "    }\n" +
                "]";
        List<RepairPo> repairPos = JSONObject.parseObject(str, new TypeReference<List<RepairPo>>(){});

        Map<String, List<String>> collect = repairPos.stream().collect(Collectors.groupingBy(x -> {
            return x.getMainSubNet() + "---" + x.getName();
        }, Collectors.mapping(x -> {
            String beginTime = x.getBeginTime();
            String endTime = x.getEndTime();
            StringBuilder data = new StringBuilder();
            // 组装日期
            while (beginTime.compareTo(endTime) <= 0){
                data.append(beginTime).append("--");
                DateTime monthFormat = DateUtil.parse(beginTime, "yyyyMM");
                // 下一个月
                DateTime nextMonth = DateUtil.offsetMonth(monthFormat, 1);
                // 改变修改值
                beginTime = nextMonth.toString("yyyyMM");
            }

            return data.toString();
        }, Collectors.toList())));

        List<RepairSummaryVo> repairSummaryVos = new ArrayList<>();
        for (String key : collect.keySet()) {

            String[] split = key.split("---");
            String mainSubNet = split[0];
            String name = split[1];
            if (StringUtils.equals(split[1],"乐山电力有限股份公司")){
                name = "乐电公司";
            }
            List<String> list = collect.get(key);
            Set<String> set = new LinkedHashSet<>();
            for (String datalist : list) {
                String[] dataSplit = datalist.split("--");
                while (dataSplit[0].compareTo(dataSplit[1]) <= 0){
                    RepairSummaryVo summaryVo = new RepairSummaryVo();
                    // 如果日期已经存在
                    if (set.contains(dataSplit[0])){
                        DateTime yyyyMM = DateUtil.parse(dataSplit[0], "yyyyMM");
                        // 下一个月
                        DateTime dateTime = DateUtil.offsetMonth(yyyyMM, 1);
                        // 改变dataSplit值
                        dataSplit[0] = dateTime.toString("yyyyMM");
                        // 跳过当前
                        continue;
                    }
                    // 如果日期不存在 则进行新增

                    // 新增set集合
                    set.add(dataSplit[0]);
                    // 新增summaryVo
                    summaryVo.setMainSubNet(mainSubNet);
                    summaryVo.setTitle(name+dataSplit[0].substring(0,4)+"年"+
                            dataSplit[0].substring(4,6)+"月"+mainSubNet+"检修计划");
                    summaryVo.setReportDate(dataSplit[0].substring(0,4)+"-"+dataSplit[0].substring(4,6));
                    summaryVo.setSummaryName("杜小凡");
                    summaryVo.setSummaryDate(DateUtil.now());
                    repairSummaryVos.add(summaryVo);

                    // 进行下个月遍历
                    DateTime yyyyMM = DateUtil.parse(dataSplit[0], "yyyyMM");
                    // 下一个月
                    DateTime dateTime = DateUtil.offsetMonth(yyyyMM, 1);
                    // 改变dataSplit值
                    dataSplit[0] = dateTime.toString("yyyyMM");
                }
            }
        }

        System.out.println("repairSummaryVos = " + repairSummaryVos);
    }


    public R getR(List<UserDo> userDos){
        return ResultUtils.success(userDos, userDos.size(), "成功");
    }
}


