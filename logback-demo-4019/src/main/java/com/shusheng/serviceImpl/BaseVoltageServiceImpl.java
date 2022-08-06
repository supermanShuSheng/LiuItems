package com.shusheng.serviceImpl;

import cn.hutool.core.util.StrUtil;
import com.shusheng.service.CimeParseAbstract;
import org.springframework.stereotype.Service;

/**
 * @author 刘闯
 * @date 2022/8/6
 */
@Service("baseVoltage")
public class BaseVoltageServiceImpl extends CimeParseAbstract {

    /**
     * 标签信息
     */
    private static final String TAG_NODE = "BaseVoltage";

    @Override
    public String getBeginTag() {
        return StrUtil.format(super.getBeginTag(), TAG_NODE);
    }

    @Override
    public String getEndTag() {
        return StrUtil.format(super.getEndTag(), TAG_NODE);
    }
}
