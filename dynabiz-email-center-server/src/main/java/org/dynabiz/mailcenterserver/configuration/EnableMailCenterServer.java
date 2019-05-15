package org.dynabiz.mailcenterserver.configuration;

import org.dynabiz.mailcenterserver.configuration.auto.MessageQueueAutoConfiguration;
import org.dynabiz.mailcenterserver.configuration.auto.TemplateEngineAutoConfiguration;
import org.dynabiz.mailcenterserver.support.mail.MailSender;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MailServerConfiguration.class,
        MailSender.class, MessageQueueAutoConfiguration.class,
        TemplateEngineAutoConfiguration.class, RepositoryConfiguration.class})
public @interface EnableMailCenterServer {
}
