package com.shusheng.domain;

import com.shusheng.domain.Do.UserDo;
import lombok.Data;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
@Data
public class FutureEntity {
    List<People> people;
    List<UserDo> userDos;
}
