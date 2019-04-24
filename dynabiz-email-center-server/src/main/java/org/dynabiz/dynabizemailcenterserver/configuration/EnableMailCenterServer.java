package org.dynabiz.dynabizemailcenterserver.configuration;

import org.dynabiz.dynabizemailcenterserver.support.mail.MailSender;
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
