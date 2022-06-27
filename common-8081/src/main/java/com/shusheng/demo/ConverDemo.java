package com.shusheng.demo;

import com.shusheng.utils.BeanConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/6/8.
 */
public class ConverDemo {
    public static void main(String[] args) {
        List<ConverDto> list = createConver();
        List<ConverVo> converVos = BeanConvertUtils.convertListTo(list, ConverVo::new);
        int i = 1;
        for (ConverVo converVo : converVos) {
            converVo.setSortId("00"+i ++);
        }
        System.out.println("converVos = " + converVos);
    }

    private static List<ConverDto> createConver() {
        List<ConverDto> list = new ArrayList<>();
        ConverDto converDto = new ConverDto();
        converDto.setId("123");
        converDto.setName("刘");
        converDto.setNote("刘123");
        list.add(converDto);
        converDto.setId("456");
        converDto.setName("闯");
        converDto.setNote("闯123");
        list.add(converDto);
        return list;
    }
}
