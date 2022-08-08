package com.shusheng.serviceImpl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.shusheng.cime.ControlAreaEntity;
import com.shusheng.service.CimeParseAbstract;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 区域档案
 * @author 刘闯
 * @date 2022/8/6
 */
@Service
public class ControlAreaServiceImpl extends CimeParseAbstract<ControlAreaEntity> {

    /**
     * 标签信息
     */
    private static final String TAG_NODE = "ControlArea";

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
    public List<ControlAreaEntity> getCimeResourceList(Dict dict) {
        return new ArrayList<>();
    }
}
