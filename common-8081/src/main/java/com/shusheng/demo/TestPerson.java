package com.shusheng.demo;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 刘闯
 * @date 2021/6/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPerson {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void main() {
        String str = DateUtil.format(DateUtil.date(), "yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println("str = " + str);
    }


}
