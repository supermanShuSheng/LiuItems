package com.shusheng.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/9/28.
 */
public class JsonEntity {
    /**
     * 巡视设备
     */
    private List<LinkedList<XssbInsertDto>> sbmc;

    public List<LinkedList<XssbInsertDto>> getSbmc() {
        return sbmc;
    }

    public void setSbmc(List<LinkedList<XssbInsertDto>> sbmc) {
        this.sbmc = sbmc;
    }
}
