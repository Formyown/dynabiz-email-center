package org.dynabiz.dynabizemailcenterserver.configuration;

import freemarker.template.Template;
import org.dynabiz.dynabizemailcenterserver.support.EmailTemplateEngine;
import org.dynabiz.dynabizemailcenterserver.support.FreeMarkerTemplateEngineSupport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemplateEngineConfiguration {
    @ConditionalOnProperty("")
    @ConditionalOnClass(Template.class)
    @Bean
    public EmailTemplateEngine freeMarkerSupport(){
        return new FreeMarkerTemplateEngineSupport();
    }

}
