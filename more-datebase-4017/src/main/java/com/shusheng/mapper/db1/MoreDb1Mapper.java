package com.shusheng.mapper.db1;

import cn.hutool.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘闯
 * @date 2022/5/23
 */
@Repository
public interface MoreDb1Mapper {

    /**
     * 查询数据
     * @return
     */
    List<JSONObject> getUserInfo();
}
