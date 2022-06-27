package com.shusheng.domain.Po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
*
* @author 刘闯
* @date 2021/3/19.
*
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPo {
    /**
     * 用户id
     */
    private int id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户年龄
     */
    private int age;
    /**
     * 创建时间
     */
    private Date createDate;
}
