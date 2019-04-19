package org.dynabiz.dynabizemailcenterserver.repository;


public interface MailTemplateRepository extends MongoRepository<MailTemplate, String> {
    MailTemplate findByName(String name);
}
