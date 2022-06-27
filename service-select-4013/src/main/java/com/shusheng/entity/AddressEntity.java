package com.shusheng.entity;

import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/8/19.
 */
@Data
public class AddressEntity {
    /**
     * 主键ID
     */
    private String objId;
    /**
     * 单位名称
     */
    private String orgName;
    /**
     * 公司编码
     */
    private String sgCode;
    /**
     * 地址
     */
    private String location;
}
