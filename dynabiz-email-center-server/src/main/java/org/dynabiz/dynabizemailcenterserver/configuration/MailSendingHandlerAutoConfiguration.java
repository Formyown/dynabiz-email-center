package org.dynabiz.dynabizemailcenterserver.configuration;


import org.dynabiz.dynabizemailcenterserver.support.MailCenterProperties;
import org.dynabiz.dynabizemailcenterserver.support.mail.JMSMailSenderSupport;
import org.dynabiz.dynabizemailcenterserver.support.mail.MailSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@ConditionalOnMissingBean(MailSender.class)
public class MailSendingHandlerAutoConfiguration {
    @ConditionalOnBean()
    @Bean
    public MailSender jmsHandler(JavaMailSender mailSender, MailCenterProperties properties) {
        return new JMSMailSenderSupport(mailSender, properties);
    }
}
