package org.dynabiz.dynabizemailcenterserver.configuration;

import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendingHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({EmailServerConfiguration.class,
        MailSendingHandler.class, MessageQueueAutoConfiguration.class,
        TemplateEngineAutoConfiguration.class, RepositoryConfiguration.class})
public @interface EnableMailCenterServer {
}
