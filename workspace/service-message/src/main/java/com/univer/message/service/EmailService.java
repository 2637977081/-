package com.univer.message.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author lvgang
 * @descript
 * @time 2018-11-16 20:06
 */
@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    public Boolean sendHtml(){
        String toEmail = "lvgang@univer.ai";
        String subject ="标题1";
        String captcha = "a1b2";
        String content = "邮箱测试成功";
        try {
            subject = messageSource.getMessage("forgot.password.subject",new Object[]{subject},LocaleContextHolder.getLocale());
            content = messageSource.getMessage("forgot.password.content",new Object[]{captcha,toEmail,content,new Date()},LocaleContextHolder.getLocale());
            System.out.println("subject:"+subject);
            System.out.println("content:"+content);
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            helper.setSentDate(new Date());
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("email:"+toEmail+" is not exit");
        }
        return false;
    }
}
