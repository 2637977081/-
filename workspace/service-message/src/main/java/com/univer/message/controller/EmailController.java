package com.univer.message.controller;

import com.univer.message.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvgang
 * @descript
 * @time 2018-11-16 20:07
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public Boolean send(){
        boolean bool = emailService.sendHtml();
        return bool;
    }
}
