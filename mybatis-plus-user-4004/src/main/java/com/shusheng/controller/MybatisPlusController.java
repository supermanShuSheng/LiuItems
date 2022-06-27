package com.shusheng.controller;

import com.shusheng.entity.ZhscjhPo;
import com.shusheng.service.ZhscjhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘闯
 * @date 2021/8/13.
 */
@RestController
public class MybatisPlusController {

//    @Autowired
//    private UserPlusMapper up;

    @Autowired
    private ZhscjhService zs;

    @GetMapping("/getPlusUser")
    public void getPlusUser(@RequestParam("current") long current, @RequestParam("size") long size){
//        System.out.println(("----- selectAll method test ------"));
//        List<UserPlus> userList = up.selectList(null);
//        userList.forEach(System.out::println);
//
//        UserPlus userPlus = upService.getById(100);
//        System.out.println("userPlus = " + userPlus);
//        // 查询
//        QueryWrapper<UserPlus> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "00").like("password", "23");
//
//        List<UserPlus> list = upService.list(queryWrapper);
//
//        System.out.println("list = " + list);
//
//        PageDTO<UserPlus> pageDTO = new PageDTO<>(current, size);
//
//        PageDTO<UserPlus> page = upService.page(pageDTO);
//
//        System.out.println("page = " + page.getRecords());
//
//        PageDTO<UserPlus> pageDTO1 = up.selectPage(page, null);
//
//        System.out.println("pageDTO1.getRecords() = " + pageDTO1.getRecords());
    }

    @GetMapping("/getZhsjInfos")
    public void getZhsjInfos(){
        List<ZhscjhPo> zp = zs.getZhsjInfos();
    }
}
