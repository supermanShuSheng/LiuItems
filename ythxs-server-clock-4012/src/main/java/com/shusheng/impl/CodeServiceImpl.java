package com.shusheng.impl;

import com.shusheng.commons.R;
import com.shusheng.domain.CodeInfoPo;
import com.shusheng.domain.CodeQueryDto;
import com.shusheng.mapper.CodeMapper;
import com.shusheng.service.CodeService;
import com.shusheng.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/6/9.
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    CodeMapper codeMapper;


    /**
     * 获取码表列表信息
     * @param codeQueryDto
     * @return
     */
    @Override
    public R<CodeInfoPo> getCodeInfos(CodeQueryDto codeQueryDto) {
        // 是否分页
        PageUtils.startPage(codeQueryDto.getPageNo(),codeQueryDto.getPageSize());
        // 进行数据的查询
        List<CodeInfoPo> codeInfoPos = codeMapper.getCodeInfos(codeQueryDto);
        return PageUtils.resultPage(codeInfoPos);
    }
}
