package com.shusheng.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2021/6/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExcel implements Serializable {

    private static final long serialVersionUID = -6439948878640405456L;

    @Excel(name = "用户ID", needMerge = true, width = 20)
    @Max(value = 2,message = "用户ID不能大于2！")
    private String userId;

    @Excel(name = "用户名称", needMerge = true, width = 20)
    private String userName;

    @Excel(name = "用户年龄", needMerge = true, width = 20)
    private Integer userAge;

    @Excel(name = "用户爱好", needMerge = true, width = 20)
    private String userLove;

}
