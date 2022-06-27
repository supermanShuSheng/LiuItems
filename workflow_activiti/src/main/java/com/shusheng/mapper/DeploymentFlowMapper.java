package com.shusheng.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
@Mapper
public interface DeploymentFlowMapper {

    @Update(value = "update act_ge_bytearray set BYTES_ = #{bytes} " +
            "where ID_ = #{id_}")
    int updateDeployGeBytearray(@Param("bytes") byte[] bytes,
                                @Param("id_") String id_);
}
