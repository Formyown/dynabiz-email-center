package org.dynabiz.mailcenterserver.configuration.auto;

import org.dynabiz.mailcenterserver.support.MailCenterProperties;
import org.dynabiz.mailcenterserver.support.mail.JMSMailSenderSupport;
import org.dynabiz.mailcenterserver.support.mail.MailSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@ConditionalOnMissingBean(MailSender.class)
@Configuration
public class MailSenderAutoConfiguration {
    @Bean
    @ConditionalOnBean(JavaMailSender.class)
    public MailSender mailSender(JavaMailSender javaMailSender, MailCenterProperties properties){
        return new JMSMailSenderSupport(javaMailSender, properties);
    }

}
