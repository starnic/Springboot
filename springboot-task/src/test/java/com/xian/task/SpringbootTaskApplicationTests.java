package com.xian.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");

        message.setTo("starnc@126.com");
        message.setFrom("719570853@qq.com");

        javaMailSender.send(message);
    }
    @Test
    public void test02() throws Exception {

        //创建复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今晚7:30开会</b>",true);

        helper.setTo("starnc@126.com");
        helper.setFrom("719570853@qq.com");
        //上传文件
        helper.addAttachment("wlop.jpg", new File("D:\\wlop.jpg"));
        helper.addAttachment("wlop1.jpg", new File("D:\\wlop1.jpg"));
        javaMailSender.send(mimeMessage);
    }

}
