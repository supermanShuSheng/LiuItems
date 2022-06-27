package com.shusheng.domain.Do;

import com.shusheng.commons.CreateDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘闯
 * @date 2021/3/19.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDo {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户年龄
     */
    private String age;
    /**
     * 创建时间
     */
    @CreateDate
    private String createDate;
}
