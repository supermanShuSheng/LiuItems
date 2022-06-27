package com.shusheng.service;

import org.springframework.stereotype.Service;

/**
 * @author 刘闯
 * @date 2021/7/5.
 */
@Service(value = "twoImpl")
public class TwoImpl implements TestStrategyService{

//    @Autowired
//    UserMapper userMapper;

    @Override
    public void sayLoves() {
        System.out.println(" Two ");
    }

}
