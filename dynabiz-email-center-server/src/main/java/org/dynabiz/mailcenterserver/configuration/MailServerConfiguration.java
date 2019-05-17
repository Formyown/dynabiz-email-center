package org.dynabiz.mailcenterserver.configuration;

import org.dynabiz.mailcenterserver.configuration.auto.MailSenderAutoConfiguration;
import org.dynabiz.mailcenterserver.controller.MessageRequestController;
import org.dynabiz.mailcenterserver.controller.TemplateTestController;
import org.dynabiz.mailcenterserver.service.MailService;
import org.dynabiz.mailcenterserver.service.TemplateService;
import org.dynabiz.mailcenterserver.service.TemplateTestService;
import org.dynabiz.mailcenterserver.support.MailCenterProperties;
import org.dynabiz.mailcenterserver.vos.entity.MailTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MailService.class, TemplateService.class, TemplateTestService.class,
        MessageRequestController.class, MailTemplate.class, TemplateTestController.class,
        MailCenterProperties.class, MailSenderAutoConfiguration.class})
public class MailServerConfiguration {

}
