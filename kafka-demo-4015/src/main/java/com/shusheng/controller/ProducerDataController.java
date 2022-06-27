package com.shusheng.controller;

import com.shusheng.commons.R;
import com.shusheng.utils.ResultUtils;
import com.shusheng.utils.SendKafkaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 刘闯
 * @date 2022/4/20.
 */
@RestController
@RequestMapping("/producer/kafka")
public class ProducerDataController {


    @Autowired
    SendKafkaUtils sendKafkaUtils;

    /**
     * 发送数据信息
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/send/{id}/{name}/{partition}")
    public R sendProducerMessage(@PathVariable String id, @PathVariable String name, @PathVariable Integer partition){
        HashMap<String, String> strMap = new HashMap<>();

        strMap.put("id", id);
        strMap.put("name", name);

        sendKafkaUtils.sendKafka(strMap, "liu.info.message", partition);

        return ResultUtils.success("成功！");
    }
}
