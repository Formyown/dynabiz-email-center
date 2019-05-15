package org.dynabiz.mailcenterserver.service;

import org.dynabiz.mailcenterserver.repository.TemplateRepository;
import org.dynabiz.mailcenterserver.support.MailCenterProperties;
import org.dynabiz.mailcenterserver.support.mail.MailSender;
import org.dynabiz.mailcenterserver.support.mq.AbstractMailMessageQueue;
import org.dynabiz.mailcenterserver.support.template.MailTemplateEngine;
import org.dynabiz.mailcenterserver.vos.MailData;
import org.dynabiz.mailcenterserver.vos.MailSendingData;
import org.dynabiz.mailcenterserver.vos.MailSendingRequest;
import org.dynabiz.mailcenterserver.vos.entity.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultSendingRequestHandler implements SendingRequestHandler {
    @Autowired
    MailSender mailSender;

    @Autowired
    AbstractMailMessageQueue mailMessageQueue;

    @Autowired
    MailTemplateEngine mailTemplateEngine;

    @Autowired
    TemplateRepository templateRepository;

    @Autowired
    MailCenterProperties properties;

    @Override
    public void send(MailSendingRequest request) {
        MailTemplate template = templateRepository.findByName(request.getTemplateName());
        MailData mailData = mailTemplateEngine.apply(template.getSubjectTemplate(), template.getContentTemplate(), request.getArgs());
        MailSendingData sendingData = MailSendingData.fromMailData(mailData, properties.getFrom(), request.getToAddress());
        mailSender.send(sendingData);
    }
}
