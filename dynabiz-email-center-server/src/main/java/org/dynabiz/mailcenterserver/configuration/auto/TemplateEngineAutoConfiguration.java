package org.dynabiz.mailcenterserver.configuration.auto;

import org.dynabiz.mailcenterserver.support.template.MailTemplateEngine;
import org.dynabiz.mailcenterserver.support.template.FreeMarkerTemplateEngineSupport;
import org.dynabiz.mailcenterserver.support.template.ThymeleafTemplateEngineSupport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TemplateEngineAutoConfiguration {

    @ConditionalOnProperty(name = "email-center.template", havingValue = "freemarker")
    @ConditionalOnClass(freemarker.template.Template.class)
    @Bean
    public MailTemplateEngine freeMarkerSupport(){
        return new FreeMarkerTemplateEngineSupport();
    }

    @ConditionalOnProperty(name = "email-center.template", havingValue = "thymeleaf")
    @ConditionalOnClass(org.thymeleaf.templatemode.TemplateMode.class)
    @Bean
    public MailTemplateEngine thymeleafSupport(){
        return new ThymeleafTemplateEngineSupport();
    }




}
