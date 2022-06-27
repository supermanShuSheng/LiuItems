package com.shusheng.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 测试
 * @author 刘闯
 * @date 2021/5/21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(value= JsonInclude.Include.NON_NULL)  // 如果里面有字段未空值 则不返回该字段

//
public class TestBean implements Serializable {

    private static final long serialVersionUID = 4068986692912749763L;

    private String id;

    private String name;
}
