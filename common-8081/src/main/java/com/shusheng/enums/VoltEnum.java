package com.shusheng.enums;

import com.shusheng.domain.People;

/**
 * @author 刘闯
 * @date 2021/3/18.
 */
public enum VoltEnum {
    // 电压枚举信息
    z33("220KV","33","2"),
    z32("110KV","32","1"),
    z25("35KV","25","5"),
    z22("10KV","22","9"),
    z21("6KV","21","6")
    ;
    /**
     * 名称
     */
    private String name;
    /**
     * 编号
     */
    private String no;
    private String coding;
    private People people;

    VoltEnum() {
    }

    VoltEnum(String name, String no, String coding) {
        this.name = name;
        this.no = no;
        this.coding = coding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }
}
