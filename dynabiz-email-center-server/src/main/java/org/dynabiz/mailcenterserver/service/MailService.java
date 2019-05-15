package org.dynabiz.mailcenterserver.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dynabiz.mailcenterserver.repository.TemplateTestDataRepository;
import org.dynabiz.mailcenterserver.support.mq.AbstractMailMessageQueue;
import org.dynabiz.mailcenterserver.vos.MailSendingRequest;
import org.dynabiz.mailcenterserver.vos.dto.SendEmailTransfer;
import org.dynabiz.mailcenterserver.vos.entity.MailTemplateTestData;
import org.dynabiz.std.exception.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);
    private ObjectMapper mapper;
    private TemplateTestDataRepository testDataRepository;
    private AbstractMailMessageQueue mailMessageQueue;

    public void sendEmail(SendEmailTransfer data) {


        try {
            MailSendingRequest req = new MailSendingRequest();
            req.setTemplateName(data.getName());
            req.setToAddress(data.getEmail());
            req.setArgs(mapper.readValue(data.getData(), Map.class));
            mailMessageQueue.push(req);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendTestData(String id){

        MailTemplateTestData testData = testDataRepository.findById(id).orElseThrow(()->RepositoryException.ITEM_NOT_FOUND);
        SendEmailTransfer data = new SendEmailTransfer();
        data.setEmail(testData.getEmail());
        data.setData(testData.getData());
        data.setName(testData.getName());
        sendEmail(data);
    }

    public MailService(ObjectMapper mapper,
                       TemplateTestDataRepository testDataRepository) {
        this.mapper = mapper;
        this.testDataRepository = testDataRepository;
    }
}
