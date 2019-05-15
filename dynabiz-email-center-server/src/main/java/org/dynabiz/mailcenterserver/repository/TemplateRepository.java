package org.dynabiz.mailcenterserver.repository;


import org.dynabiz.mailcenterserver.vos.entity.MailTemplate;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TemplateRepository extends PagingAndSortingRepository<MailTemplate, String> {
    MailTemplate findByName(String name);
}
