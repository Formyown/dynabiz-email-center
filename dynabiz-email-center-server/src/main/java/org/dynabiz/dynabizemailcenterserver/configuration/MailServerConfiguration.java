package org.dynabiz.dynabizemailcenterserver.configuration;

import org.dynabiz.dynabizemailcenterserver.configuration.auto.MailSenderAutoConfiguration;
import org.dynabiz.dynabizemailcenterserver.controller.MailMessageController;
import org.dynabiz.dynabizemailcenterserver.controller.MailTemplateTestController;
import org.dynabiz.dynabizemailcenterserver.service.MailService;
import org.dynabiz.dynabizemailcenterserver.service.MailTemplateService;
import org.dynabiz.dynabizemailcenterserver.service.MailTemplateTestService;
import org.dynabiz.dynabizemailcenterserver.support.MailCenterProperties;
import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MailService.class, MailTemplateService.class, MailTemplateTestService.class,
        MailMessageController.class, MailTemplate.class, MailTemplateTestController.class,
        MailCenterProperties.class, MailSenderAutoConfiguration.class})
public class MailServerConfiguration {

}
