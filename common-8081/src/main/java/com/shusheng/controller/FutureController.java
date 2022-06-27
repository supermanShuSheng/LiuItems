package com.shusheng.controller;

import com.shusheng.commons.R;
import com.shusheng.demo.A;
import com.shusheng.domain.HelloEntity;
import com.shusheng.service.CompleServerImpl;
import com.shusheng.service.FutureServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
@RestController
@RequestMapping(value = "/future")
@Validated
public class FutureController {

    @Autowired
    FutureServerImpl futureServer;

    @Autowired
    CompleServerImpl compleServer;

    @GetMapping("/queryFuture")
    public R getFuture(){
        return futureServer.getFuture();
    }


    @PostMapping("/testDemo")
    public void testDemo(@RequestBody HelloEntity helloEntity) {
        System.out.println("helloEntity = " + helloEntity);
    }

    @GetMapping("/queryComple")
    public R queryComple() throws ExecutionException, InterruptedException {
       return compleServer.getFuture();
    }

    @PostMapping("/testSt")
    public R testSt(@Valid @RequestBody A a){
        System.out.println("a = " + a);
        return null;
    }
}
