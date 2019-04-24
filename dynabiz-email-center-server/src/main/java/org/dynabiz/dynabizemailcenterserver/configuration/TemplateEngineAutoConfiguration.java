package org.dynabiz.dynabizemailcenterserver.configuration;

import freemarker.template.Template;
import org.dynabiz.dynabizemailcenterserver.support.template.MailTemplateEngine;
import org.dynabiz.dynabizemailcenterserver.support.template.FreeMarkerTemplateEngineSupport;
import org.dynabiz.dynabizemailcenterserver.support.template.ThymeleafTemplateEngineSupport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
public class TemplateEngineAutoConfiguration {
    @ConditionalOnProperty(name = "spring.email-center.template", havingValue = "freemarker", matchIfMissing = true)
    @ConditionalOnClass(Template.class)
    @Bean
    public MailTemplateEngine freeMarkerSupport(){
        return new FreeMarkerTemplateEngineSupport();
    }

    @ConditionalOnProperty(name = "spring.email-center.template", havingValue = "thymeleaf")
    @ConditionalOnClass(TemplateMode.class)
    @Bean
    public MailTemplateEngine thymeleafSupport(){
        return new ThymeleafTemplateEngineSupport();
    }




}
