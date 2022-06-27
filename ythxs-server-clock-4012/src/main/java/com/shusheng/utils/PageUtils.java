package com.shusheng.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shusheng.commons.R;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/2/24.
 */
public class PageUtils {
    /**
     * 获取分页后的数据获取
     * @param parameter
     * @return
     */
    public static R resultPage(List<?> parameter){
        PageInfo<?> pages = new PageInfo<>(parameter);
        if (pages.getList() != null && pages.getList().size()>0){
            return ResultUtils.success(pages.getList(), (int) pages.getTotal());
        }
        return ResultUtils.success(706,"无数据");
    }

    /**
     * 开启分页
     * @param pageSize
     * @param pageNo
     */
    public static void startPage(Integer pageNo, Integer pageSize){
        if (pageSize != null && pageNo != null){
            PageHelper.startPage(pageNo,pageSize);
        }
    }
}
