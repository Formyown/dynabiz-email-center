package org.dynabiz.dynabizemailcenterserver.repository;


import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplate;
import org.springframework.data.repository.CrudRepository;

public interface MailTemplateRepository extends CrudRepository<MailTemplate, String> {
    MailTemplate findByName(String name);
}
