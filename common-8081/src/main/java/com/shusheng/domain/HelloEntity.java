package com.shusheng.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */

@Data
public class HelloEntity {
    @Setter(AccessLevel.NONE)
    private String pOrgId;
    private String pOrgCode;
}
