package org.dynabiz.mailcenterserver.repository;


import org.dynabiz.mailcenterserver.vos.entity.MailTemplateTestData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TemplateTestDataRepository extends MongoRepository<MailTemplateTestData, String> {
}
