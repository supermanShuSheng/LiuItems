package com.shusheng.mapper;

import com.shusheng.entity.AddressEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author 刘闯
 * @date 2021/8/19.
 */
@Repository
public interface AddressMapper {

    /**
     * 通过Id查询服务地址
     */
    AddressEntity getAddressById(String objId);

    /**
     * 查询服务地址列表
     */
    List<AddressEntity> getAddressInfos();
}
