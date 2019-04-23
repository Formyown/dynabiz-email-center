package org.dynabiz.dynabizemailcenterserver.controller;


import org.dynabiz.dynabizemailcenterserver.service.MailService;
import org.dynabiz.dynabizemailcenterserver.vos.dto.SendEmailTransfer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mail")
@RestController
public class MailMessageController {
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

    public MailMessageController(MailService emailService) {
        this.emailService = emailService;
    }
}
