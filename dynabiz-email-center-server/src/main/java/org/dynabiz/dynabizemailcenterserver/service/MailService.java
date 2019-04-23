package org.dynabiz.dynabizemailcenterserver.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dynabiz.dynabizemailcenterserver.repository.MailTemplateTestDataRepository;
import org.dynabiz.dynabizemailcenterserver.vos.dto.SendEmailTransfer;
import org.dynabiz.dynabizemailcenterserver.vos.entity.MailTemplateTestData;
import org.dynabiz.std.exception.RepositoryException;
import org.dynabiz.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);
    private StringRedisTemplate template;
    private ObjectMapper mapper;
    private MailTemplateTestDataRepository testDataRepository;

    public void sendEmail(SendEmailTransfer data) {

        try {
            template.convertAndSend("emailMQ", mapper.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            logger.error(e.toString());
        }

    }

    public void sendTestData(String id){
        MailTemplateTestData testData = Assert.notNull(testDataRepository.findById(id), RepositoryException.ITEM_NOT_FOUND);
        SendEmailTransfer data = new SendEmailTransfer();
        data.setEmail(testData.getEmail());
        data.setData(testData.getData());
        data.setName(testData.getName());

        sendEmail(data);

    }

    public MailService(StringRedisTemplate template,
                       ObjectMapper mapper,
                       MailTemplateTestDataRepository testDataRepository) {
        this.template = template;
        this.mapper = mapper;
        this.testDataRepository = testDataRepository;
    }
}
