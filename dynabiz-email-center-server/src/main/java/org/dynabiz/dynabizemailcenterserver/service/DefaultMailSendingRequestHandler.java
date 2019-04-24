package org.dynabiz.dynabizemailcenterserver.service;

import org.dynabiz.dynabizemailcenterserver.repository.MailTemplateRepository;
import org.dynabiz.dynabizemailcenterserver.support.MailCenterProperties;
import org.dynabiz.dynabizemailcenterserver.support.mail.MailSender;
import org.dynabiz.dynabizemailcenterserver.support.mq.AbstractMailMessageQueue;
import org.dynabiz.dynabizemailcenterserver.support.template.MailTemplateEngine;
import org.dynabiz.dynabizemailcenterserver.vos.MailData;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingData;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;
import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultMailSendingRequestHandler implements MailSendingRequestHandler {
    @Autowired
    MailSender mailSender;

    @Autowired
    AbstractMailMessageQueue mailMessageQueue;

    @Autowired
    MailTemplateEngine mailTemplateEngine;

    @Autowired
    MailTemplateRepository mailTemplateRepository;

    @Autowired
    MailCenterProperties properties;

    @Override
    public void send(MailSendingRequest request) {
        MailTemplate template = mailTemplateRepository.findByName(request.getTemplateName());
        MailData mailData = mailTemplateEngine.apply(template.getSubjectTemplate(), template.getContentTemplate(), request.getArgs());
        MailSendingData sendingData = MailSendingData.fromMailData(mailData, properties.getFrom(), request.getToAddress());
        mailSender.send(sendingData);
    }
}
