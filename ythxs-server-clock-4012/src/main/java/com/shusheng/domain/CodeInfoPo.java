package com.shusheng.domain;

import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/6/9.
 */
@Data
public class CodeInfoPo {
    /**
     * 主键ID
     */
    private String objId;
    /**
     * Value值
     */
    private String codeValue;
    /**
     * 名称
     */
    private String codeText;
    /**
     * 父ID
     */
    private String pobjId;
}
