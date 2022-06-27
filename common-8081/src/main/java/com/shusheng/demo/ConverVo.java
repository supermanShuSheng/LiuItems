package com.shusheng.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 刘闯
 * @date 2021/6/8.
 */
@Data
public class ConverVo {
    private String id;
    @Getter
    @Setter
    private String name;
    private String note;
    private String sortId;
}
