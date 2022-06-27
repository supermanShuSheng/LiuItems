package com.shusheng.function.email;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author 刘闯
 * @date 2022/5/18
 */
public class SendMail {

    /**
     * 发送邮件
     * @param email
     * @param address
     */
    public static void sendMail(Email email,String address){

        // 定义收件人
        InternetAddress[] to_address = new InternetAddress[1];
        try {
            to_address[0] = new InternetAddress(address);
        } catch (AddressException e) {
            e.printStackTrace();
        }

        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", MailProperties.HOST);
        properties.setProperty("mail.smtp.port", "25");  //设置端口
        properties.setProperty("mail.smtp.auth", "true");  // 打开认证
        properties.setProperty("mail.smtp.connection-timeout", "15000");//SMTP服务器连接超时时间
        properties.setProperty("mail.smtp.timeout", "60000");//发送邮件超时时间

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailProperties.USERNAME,MailProperties.AUTHORIZATION_CODE);
            }
        });


        // 定义头部字段及发邮件
        try {
            // 创建默认的MimeMessage对象
            MimeMessage message = new MimeMessage(session);
            // 设置发件人From 头部字段
            message.setFrom(new InternetAddress(MailProperties.USERNAME, MailProperties.FROM, "UTF-8"));
            // 设置收件人To 头部字段
            message.addRecipients(Message.RecipientType.TO, to_address);
            // 设置Subject 头部字段
            message.setSubject(email.getSubject());
            // 设置消息体
            message.setText(email.getContent());

            // 发送消息
            Transport.send(message);
            System.out.println("发送成功");

        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
