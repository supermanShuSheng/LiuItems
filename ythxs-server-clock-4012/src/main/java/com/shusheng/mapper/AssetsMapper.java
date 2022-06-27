package com.shusheng.mapper;

import com.shusheng.domain.Card;
import com.shusheng.dynamic.PhysicalAssetsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/8/13.
 */
@Repository
public interface AssetsMapper {

    /**
     * 动态更新资产信息
     * @param pa
     * @return
     */
    int updateAssets(PhysicalAssetsEntity pa);

    List<Card> getCards();

    int updateDate();
}
