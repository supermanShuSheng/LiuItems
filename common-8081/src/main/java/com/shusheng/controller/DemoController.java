package com.shusheng.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileAppender;
import com.shusheng.demo.LiuDemo;
import com.shusheng.service.CCCCDDDD;
import com.shusheng.strategy.TestStrategy;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author 刘闯
 * @date 2021/4/2.
 */
@RestController
@Api(tags = "测试认证")
public class DemoController {

    private String name;

    @Autowired
    private LiuDemo liuDemo;

    final TestStrategy testStrategy;

    public DemoController(TestStrategy testStrategy) {
        this.testStrategy = testStrategy;
    }


    @RequestMapping(value = "/loginIn", method = RequestMethod.GET)
    public String loginIn(){
        StpUtil.setLoginId(344439833);
        return "登录成功!";
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(){
        StpUtil.logout();
        return "注销成功";
    }

    @RequestMapping(value = "/isLogin", method = RequestMethod.GET)
    public String isLogin(){
        boolean login = StpUtil.isLogin();
        if (login){
            return "该用户已在线！";
        }
        System.out.println(" 用户未登录123！ ");
        return "用户未登录！";
    }

    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public void loginUser(){
        // 检验当前会话是否已经登录, 如果未登录，则抛出异常：`NotLoginException`
        System.out.println("aa");
        StpUtil.checkLogin();
    }

    @RequestMapping(value = "/beanDemo", method = RequestMethod.GET)
    public String beanDemo(){
        // 检验当前会话是否已经登录, 如果未登录，则抛出异常：`NotLoginException`
        return BeanUtilsDemo.getBeanDemo();
    }


    @PostMapping("/getSayLove")
    public void sayLove(Object a){
        CCCCDDDD d = (CCCCDDDD) a;
        System.out.println("d = " + d.getAbc());
    }

    @PostMapping("/getOrg")
    public void getOrg(@RequestBody QQ qq){
        System.out.println(qq);
    }

    static class QQ{
        private String orgName;

        public QQ(String orgName) {
            this.orgName = orgName;
        }

        public QQ() {
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        @Override
        public String toString() {
            return "QQ{" +
                    "orgName='" + orgName + '\'' +
                    '}';
        }
    }

    @GetMapping(value = "/addLogs")
    public void addLogs(@RequestParam("logs") String logs){
        System.out.println("输出日志");
        File file = FileUtil.file("C:\\Users\\admin\\Desktop\\errorLog.log");
        // 写入文件
        FileAppender appender = new FileAppender(file, 16, true);

        appender.append(logs);
        appender.flush();
    }

    /**
     * 获取异常的调用堆栈信息。
     *
     * @return 调用堆栈
     */
    public static String toStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try
        {
            e.printStackTrace(pw);
            return sw.toString();
        }
        catch(Exception e1)
        {
            return "";
        }
    }

}
