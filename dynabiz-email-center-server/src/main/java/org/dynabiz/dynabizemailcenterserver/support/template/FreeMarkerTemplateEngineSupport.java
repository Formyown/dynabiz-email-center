package org.dynabiz.dynabizemailcenterserver.support.template;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreeMarkerTemplateEngineSupport implements EmailTemplateEngine {
    private static final Logger logger = LoggerFactory.getLogger(FreeMarkerTemplateEngineSupport.class);

    public FreeMarkerTemplateEngineSupport(){

    }

    @Override
    public EmailEntity apply(String titleTemplate, Map<String, Object> titleArgs, String bodyTemplate, Map<String, Object> bodyArgs) {
        Configuration config = new Configuration(Configuration.VERSION_2_3_0);
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate("BODY_TEMPLATE", bodyTemplate);
        stringLoader.putTemplate("TITLE_TEMPLATE", titleTemplate);
        config.setTemplateLoader(stringLoader);



        try {
            Template bodyTemplate = config.getTemplate("BODY_TEMPLATE","utf-8");
            Template titleTemplate = config.getTemplate("TITLE_TEMPLATE","utf-8");

            StringWriter contentWriter = new StringWriter();
            bodyTemplate.process(dataEntity, contentWriter);

            StringWriter titleWriter = new StringWriter();
            titleTemplate.process(dataEntity, titleWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
