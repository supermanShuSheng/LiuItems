package com.shusheng.enums;

import com.shusheng.domain.People;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
public enum GroupEntity {
    //
    A("1", "1,1,2,1,2,3,4,5,6"),

    B("2","1,2")
    ;
    private String id;
    private String val;

    GroupEntity() {
    }

    GroupEntity(String id, String val) {
        this.id = id;
        this.val = val;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }


}
