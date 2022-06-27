package com.shusheng.mapper.db2;

import cn.hutool.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘闯
 * @date 2022/5/23
 */
@Repository
public interface MoreDb2Mapper {

    /**
     * 查询服务器数据
     * @return
     */
    List<JSONObject> getTranInfo();
}
