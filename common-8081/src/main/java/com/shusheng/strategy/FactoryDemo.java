package com.shusheng.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 刘闯
 * @date 2021/7/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryDemo {


    @Autowired
    FactoryStra factoryStra;

    @Test
    public void factoryTest() {
        P p1 = factoryStra.getFactory("p1");
        p1.getValue();
    }

}
