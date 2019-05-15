package org.dynabiz.mailcenterserver.repository;


import org.dynabiz.mailcenterserver.vos.entity.MailTemplateTestData;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TemplateTestDataRepository extends PagingAndSortingRepository<MailTemplateTestData, String> {
}
