package com.shusheng.mapper;

import com.shusheng.domain.CodeInfoPo;
import com.shusheng.domain.CodeQueryDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/6/9.
 */
@Repository
public interface CodeMapper {
    /**
     * 获取码表列表信息
     * @param codeQueryDto
     * @return
     */
    List<CodeInfoPo> getCodeInfos(CodeQueryDto codeQueryDto);
}
