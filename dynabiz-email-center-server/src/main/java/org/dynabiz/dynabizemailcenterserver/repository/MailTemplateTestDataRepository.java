package org.dynabiz.dynabizemailcenterserver.repository;

import com.timescodes.dawn.timescodingdawnmsmainmailifv1.vos.entity.MailTemplateTestData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MailTemplateTestDataRepository extends MongoRepository<MailTemplateTestData, String> {

}
