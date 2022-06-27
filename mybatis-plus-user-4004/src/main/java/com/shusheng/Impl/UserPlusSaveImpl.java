package com.shusheng.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shusheng.entity.ZhscjhPo;
import com.shusheng.mapper.UserPlusMapper;
import com.shusheng.service.ZhscjhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/8/13.
 */
@Service
public class UserPlusSaveImpl extends ServiceImpl<UserPlusMapper, ZhscjhPo> implements ZhscjhService {

    @Autowired
    UserPlusMapper upm;


    @Override
    public List<ZhscjhPo> getZhsjInfos() {
        List<ZhscjhPo> zp = upm.getZhsjInfos();
        System.out.println("zp = " + zp);

        return  upm.selectList(null);

    }
}
