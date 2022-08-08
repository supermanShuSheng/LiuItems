package com.shusheng.serviceImpl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.shusheng.cime.DiscreteEntity;
import com.shusheng.service.CimeParseAbstract;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 开关状态值
 * @author 刘闯
 * @date 2022/8/6
 */
@Service
public class DiscreteServiceImpl extends CimeParseAbstract<DiscreteEntity> {

    /**
     * 标签信息
     */
    private static final String TAG_NODE = "Discrete";

    @Override
    public String getBeginTag(String city) {
        return StrUtil.format(super.getBeginTag(city), TAG_NODE);
    }

    @Override
    public String getEndTag(String city) {
        return StrUtil.format(super.getEndTag(city), TAG_NODE);
    }

    /**
     * 实际业务操作
     * @param dict 传入字典值
     */
    @Override
    public List<DiscreteEntity> getCimeResourceList(Dict dict) {
        return new ArrayList<>();
    }
}
