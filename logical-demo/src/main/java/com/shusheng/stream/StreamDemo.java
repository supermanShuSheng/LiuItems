package com.shusheng.stream;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2021/7/22.
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<IntervalTreeEntity> intervals = getIntervals();

        List<IntervalTreeEntity> dy = intervals.stream().filter(x -> StringUtils.equals(x.getTypeName(), "间隔单元1")).collect(Collectors.toList());

        for (IntervalTreeEntity intervalTreeEntity : dy) {
            Map<String, List<IntervalTreeEntity>> collect = intervals.stream().filter(x -> StringUtils.equals(x.getIntervalUnit(), intervalTreeEntity.getObjName()))
                    .collect(Collectors.groupingBy(IntervalTreeEntity::getTypeName));
            intervalTreeEntity.setGroupUnit(collect);
        }

        System.out.println("dy = " + dy);
    }



    private static List<IntervalTreeEntity> getIntervals(){
        String str = "[{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"132\",\"objId\":\"3f230d1fe9244f40a8e8c94ea04549c1\",\"typeName\":\"主变\",\"objName\":\"1#主变\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"1\",\"objId\":\"c0d8fca9e673480e950376a9191cb2c3\",\"typeName\":\"断路器\",\"objName\":\"断路器\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"181间隔\",\"objId\":\"7a1c4c8e752b4ca1812b6cd600111210\",\"typeName\":\"电流互感器\",\"objName\":\"电流互感器\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"1\",\"objId\":\"8febb8b03532439d877a13b703029280\",\"typeName\":\"电压互感器\",\"objName\":\"1\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"181间隔\",\"objId\":\"9eab060a7a8e459287f00ce0629393e7\",\"typeName\":\"电压互感器\",\"objName\":\"电压互感器 \"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"181间隔\",\"objId\":\"38adb00078d449a08d573c5bc79db483\",\"typeName\":\"避雷器\",\"objName\":\"避雷器\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"181间隔\",\"objId\":\"9d07744983054c76b7d07049c7fe38e2\",\"typeName\":\"避雷器\",\"objName\":\"避雷器\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"987\",\"objId\":\"7457106f52e8436297e8b3f169dd185c\",\"typeName\":\"电力电容器\",\"objName\":\"电容器\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"1811间隔\",\"objId\":\"c36563b4acad469486b929eb3eee3d62\",\"typeName\":\"隔离开关\",\"objName\":\"隔离刀闸\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"581间隔\",\"objId\":\"09ed4d081bdc48748b3f9174d4ecc9ab\",\"typeName\":\"开关柜\",\"objName\":\"开关柜\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"112\",\"objId\":\"135f615798d94b7cab84f4cbf97735dc\",\"typeName\":\"消弧装置\",\"objName\":\"消弧装置\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"987\",\"objId\":\"fe7b6433db0340e68ae2ae81ab2d46b5\",\"typeName\":\"电抗器\",\"objName\":\"电抗器\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"1\",\"objId\":\"f7ecc9ccc038494885349913cae17d3c\",\"typeName\":\"GIS\",\"objName\":\"GIS设备\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"121\",\"objId\":\"ed1cdfca80024417846ff3ffec98af98\",\"typeName\":\"HGIS\",\"objName\":\"HGIS\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"112\",\"objId\":\"c0124bb2c5104fe1a79b22f61dcc2295\",\"typeName\":\"接地变\",\"objName\":\"接地变\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"无\",\"objId\":\"7a3adf0565544851bad2041107619b98\",\"typeName\":\"间隔单元\",\"objName\":\"123\"},{\"subsId\":\"11S104000000000000\",\"intervalUnit\":\"无\",\"objId\":\"bd83a4c195a84eb8a880a8e452777225\",\"typeName\":\"间隔单元\",\"objName\":\"181间隔\"}]";
        return JSON.parseArray(str, IntervalTreeEntity.class);

    }
}
