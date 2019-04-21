package org.dynabiz.dynabizemailcenterserver.support.template;

import java.util.Map;

public interface EmailTemplateEngine {
    EmailEntity apply(String titleTemplate, Map<String, Object> titleArgs,
                 String bodyTemplate, Map<String, Object> bodyArgs);

    class EmailEntity {
        public EmailEntity(String title, String body) {
            this.title = title;
            this.body = body;
        }

        public String title;
        public String body;
    }
}
