package org.dynabiz.dynabizemailcenterserver.support.mail;

import org.dynabiz.dynabizemailcenterserver.support.MailCenterProperties;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

public class JMSMailSenderSupport implements MailSender {
    private static final Logger logger = LoggerFactory.getLogger(JMSMailSenderSupport.class);
    private JavaMailSender mailSender;
    private MailCenterProperties properties;

    public JMSMailSenderSupport(JavaMailSender mailSender, MailCenterProperties properties){
        this.mailSender = mailSender;
        this.properties = properties;
    }

    @Override
    public void send(MailSendingData mail) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(mail.getFromAddress());
            helper.setTo(mail.getToAddress());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true);
            mailSender.send(message);
        } catch (Exception e) {
            logger.info("Send email error :" + e.toString());
            return;
        }
        switch (this.properties.getLogLevel()){
            case BODY: logger.info("Send email to " + mail.getToAddress() + " " + mail.getSubject() + ":" + mail.getBody()); break;
            case TITLE: logger.info("Send email to " + mail.getToAddress() + " " + mail.getSubject()); break;
            default: break;
        }

    }
}
