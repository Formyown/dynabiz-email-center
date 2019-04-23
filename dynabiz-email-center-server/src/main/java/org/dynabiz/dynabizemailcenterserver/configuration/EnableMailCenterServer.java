package org.dynabiz.dynabizemailcenterserver.configuration;

import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendingHandler;
import org.springframework.context.annotation.Import;

@Import({MailSendingHandler.class, MessageQueueAutoConfiguration.class,
        TemplateEngineAutoConfiguration.class, RepositoryConfiguration.class})
public class EnableMailCenterServer {
}
