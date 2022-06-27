package com.shusheng.domain.Vo;

import com.shusheng.domain.People;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 刘闯
 * @date 2021/4/1.
 */

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Father extends People {

    /**
     *
     */
    private String fatherName;
}
