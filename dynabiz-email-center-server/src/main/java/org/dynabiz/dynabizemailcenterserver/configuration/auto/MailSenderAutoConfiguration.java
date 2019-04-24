package org.dynabiz.dynabizemailcenterserver.configuration.auto;

import freemarker.template.Template;
import org.dynabiz.dynabizemailcenterserver.support.MailCenterProperties;
import org.dynabiz.dynabizemailcenterserver.support.mail.JMSMailSenderSupport;
import org.dynabiz.dynabizemailcenterserver.support.mail.MailSender;
import org.dynabiz.dynabizemailcenterserver.support.template.FreeMarkerTemplateEngineSupport;
import org.dynabiz.dynabizemailcenterserver.support.template.MailTemplateEngine;
import org.dynabiz.dynabizemailcenterserver.support.template.ThymeleafTemplateEngineSupport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.templatemode.TemplateMode;

@ConditionalOnMissingBean(MailSender.class)
@Configuration
public class MailSenderAutoConfiguration {
    @Bean
    @ConditionalOnBean(JavaMailSender.class)
    public MailSender jmsMailSender(JavaMailSender javaMailSender, MailCenterProperties properties){
        return new JMSMailSenderSupport(javaMailSender, properties);
    }

}
