package org.dynabiz.dynabizemailcenterserver.service;


import org.dynabiz.dynabizemailcenterserver.repository.MailTemplateTestDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
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
        MailTemplateTestData testData = Assert.notNull(testDataRepository.findById(id), RepositoryException.notFound());
        SendEmailTransfer data = new SendEmailTransfer();
        data.setEmail(testData.getEmail());
        data.setData(testData.getData());
        data.setName(testData.getName());

        sendEmail(data);

    }

    public EmailService(StringRedisTemplate template,
                        ObjectMapper mapper,
                        MailTemplateTestDataRepository testDataRepository) {
        this.template = template;
        this.mapper = mapper;
        this.testDataRepository = testDataRepository;
    }
}
