package com.shusheng.controller;

import com.shusheng.commons.R;
import com.shusheng.domain.CodeInfoPo;
import com.shusheng.domain.CodeQueryDto;
import com.shusheng.service.CodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * @author 刘闯
 * @date 2021/6/9.
 */

@RestController
@RequestMapping("/code")
@Api(tags = "码表修改服务")
@CrossOrigin(origins = "*")
public class CodeController {

    @Autowired
    CodeService codeService;

    @ApiOperation(value = "获取码表列表信息", response = CodeInfoPo.class)
    @RequestMapping(value = "/getCodeInfos", method = RequestMethod.POST)
    public R<CodeInfoPo> getCodeInfos(@Valid @RequestBody CodeQueryDto codeQueryDto){

        return codeService.getCodeInfos(codeQueryDto);
    }


    // 测试传参参数
    @GetMapping(value = "/getCodeList")
    public String getCodeList(@RequestParam("codeValue") String... codeValue){
        Arrays.stream(codeValue).forEach(System.out::println);
        return "请求成功";
    }
}
