package com.univer.message.service;

import com.univer.base.util.CaptchaUtil;
import com.univer.message.po.Email;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @
 */
@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private StringRedisTemplate template;

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    /**
     * 发送验证码
     * @param email
     * @return
     */
    public Boolean sendCaptcha(Email email){
        Boolean bool = false;
        email.setFromEmail(fromEmail);
        if(sendEmail(email)){
            bool = true;
            email.setStatus("sending");
            //数据库存储
        }
        return bool;
    }

    public Boolean sendMessage(Email email){
        String subject = messageSource.getMessage("send.message.subject",new Object[]{email.getSubject()},LocaleContextHolder.getLocale());
        String content = messageSource.getMessage("send.message.content",new Object[]{email.getContent()},LocaleContextHolder.getLocale());
        email.setSubject(subject);
        email.setContent(content);
        Boolean bool = false;
        if(sendEmail(email)){
            bool = true;
            email.setStatus("sending");
            //数据库存储
        }
        return bool;
    }

    private boolean sendEmail(Email email){
        boolean bool = false;
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(email.getFromEmail());
            helper.setTo(email.getToEmail());
            email.setCreateTime(new Date());
            helper.setSentDate(email.getCreateTime());
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), true);
            mailSender.send(message);
            return true;
        }catch (Exception e){
            logger.error("email:{0} is not exit,cause throws by{1}",email.getToEmail(),e.getMessage());
        }
        return bool;
    }
}
