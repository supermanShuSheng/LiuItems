package com.shusheng.service;

import com.shusheng.commons.R;
import com.shusheng.domain.CodeInfoPo;
import com.shusheng.domain.CodeQueryDto;

/**
 * @author 刘闯
 * @date 2021/6/9.
 */
public interface CodeService {
    /**
     * 获取码表列表信息
     * @param codeQueryDto
     * @return
     */
    R<CodeInfoPo> getCodeInfos(CodeQueryDto codeQueryDto);
}
