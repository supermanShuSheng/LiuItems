package com.shusheng.mapper;

import com.shusheng.domain.excel.DeptEntity;
import com.shusheng.domain.excel.OrgEntity;
import org.springframework.stereotype.Repository;

/**
 * @author 刘闯
 * @date 2021/7/30.
 */
@Repository
public interface OrgMapper {
    int updateOrg(OrgEntity entity);

    int updateDept(DeptEntity entity);
}
