package com.shusheng.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/5/21.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/getTestBean", method = RequestMethod.GET)
    public List<TestBean> getTestBean(){
        List<TestBean> testBeans = new ArrayList<>();
        TestBean testBean = new TestBean("1",null);
        TestBean testBean1 = new TestBean("2","null");
        testBeans.add(testBean1);
        testBeans.add(testBean);
        return testBeans;
    }

}
