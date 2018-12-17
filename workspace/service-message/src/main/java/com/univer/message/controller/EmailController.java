package com.univer.message.controller;

import com.univer.base.controller.BaseController;
import com.univer.base.vo.ResultVo;
import com.univer.message.constant.MsgConstant;
import com.univer.message.po.Email;
import com.univer.message.service.EmailService;
import com.univer.message.vo.EmailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Scope("prototype")
public class EmailController extends BaseController<EmailVo>{

    @Autowired
    private EmailService emailService;

    @GetMapping("/captcha")
    public ResultVo Captcha(Email email){
        boolean bool = emailService.sendCaptcha(email);
        if(bool){
            return resultVo.getInstance(HttpStatus.OK.toString());
        }else {
            return resultVo.getInstance(MsgConstant.SEND_EMAIL_ERROR);
        }
    }

    @PostMapping("/message")
    public ResultVo sendMessage(Email email){
        boolean bool = emailService.sendMessage(email);
        if(bool){
            return resultVo.getInstance(HttpStatus.OK.toString());
        }else {
            return resultVo.getInstance(MsgConstant.SEND_EMAIL_ERROR);
        }
    }
}
