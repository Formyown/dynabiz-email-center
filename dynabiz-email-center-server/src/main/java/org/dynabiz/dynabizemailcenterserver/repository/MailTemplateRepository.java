package org.dynabiz.dynabizemailcenterserver.repository;


import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplate;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MailTemplateRepository extends PagingAndSortingRepository<MailTemplate, String> {
    MailTemplate findByName(String name);
}
