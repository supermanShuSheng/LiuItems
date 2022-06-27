package com.shusheng.function.email;

/**
 * @author 刘闯
 * @date 2022/5/18
 */
public class EmailTest {
    public static void main(String[] args) {

        String subject = "Java测试邮件";
        String content = "测试内容！";
        String address = "1056630628@qq.com";

        Email email = new Email();
        email.setSubject(subject);
        email.setContent(content);

        SendMail.sendMail(email, address);
    }
}
