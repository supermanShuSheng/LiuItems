package com.shusheng.controller;

import com.shusheng.mapper.AddressMapper;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘闯
 * @date 2021/8/19.
 */
@RestController
public class AddressController {

    @Autowired
    AddressMapper am;

    @GetMapping("/getAddress")
    public String getAddress(@RequestParam("objId") String objId) {
        return null;
    }


}
