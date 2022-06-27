package com.shusheng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shusheng.entity.ZhscjhPo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/8/13.
 */
@Repository
public interface UserPlusMapper extends BaseMapper<ZhscjhPo> {

    List<ZhscjhPo> getZhsjInfos();
}
