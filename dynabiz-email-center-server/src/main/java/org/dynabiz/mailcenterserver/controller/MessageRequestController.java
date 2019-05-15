package org.dynabiz.mailcenterserver.controller;


import org.dynabiz.mailcenterserver.service.MailService;
import org.dynabiz.mailcenterserver.vos.dto.SendEmailTransfer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mail")
@RestController
public class MessageRequestController {
    private MailService emailService;

    /**
     * 发送邮件
     * @param sendEmailTransfer SendEmailTransfer
     */
    @PostMapping
    public void sendEmail(SendEmailTransfer sendEmailTransfer){
        emailService.sendEmail(sendEmailTransfer);
    }

    @PostMapping("/test")
    public void sendTestEmail(@RequestParam String id){
        emailService.sendTestData(id);
    }

    public MessageRequestController(MailService emailService) {
        this.emailService = emailService;
    }
}
