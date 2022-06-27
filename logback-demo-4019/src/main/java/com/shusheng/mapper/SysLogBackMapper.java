package com.shusheng.mapper;

import cn.hutool.json.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 刘闯
 * @date 2022/5/24
 */
@Mapper
public interface SysLogBackMapper {


    @Select(value = "select * from user")
    List<JSONObject> queryLogInfo();
}
