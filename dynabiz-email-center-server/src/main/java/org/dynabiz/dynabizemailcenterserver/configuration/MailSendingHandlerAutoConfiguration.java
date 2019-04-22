package org.dynabiz.dynabizemailcenterserver.configuration;


import org.dynabiz.dynabizemailcenterserver.support.mail.JMSHandler;
import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendingHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(MailSendingHandler.class)
public class MailSendingHandlerAutoConfiguration {
    @ConditionalOnBean()
    @Bean
    public MailSendingHandler jmsHandler() {
        return new JMSHandler();
    }
}
