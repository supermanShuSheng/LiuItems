package com.shusheng.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 刘闯
 * @date 2022/5/23
 */
@Mapper
public interface DemoConnMapper {

    @Select(value = "select count(1) from TRAN_DATE")
    Integer getTranNumber();
}
