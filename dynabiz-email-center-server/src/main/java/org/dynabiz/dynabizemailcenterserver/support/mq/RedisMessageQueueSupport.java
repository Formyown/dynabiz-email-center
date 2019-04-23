package org.dynabiz.dynabizemailcenterserver.support.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendingHandler;
import org.dynabiz.dynabizemailcenterserver.vos.MailSendingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;

public class RedisMessageQueueSupport extends AbstractMailMessageQueue {
    private static final Logger logger = LoggerFactory.getLogger(RedisMessageQueueSupport.class);
    private StringRedisTemplate template;
    private ObjectMapper mapper;


    public RedisMessageQueueSupport(MailSendingHandler mailSendingHandler, StringRedisTemplate template,
                                    ObjectMapper mapper) {
        super(mailSendingHandler);
        this.template = template;
        this.mapper = mapper;

    }

    @Override
    public void push(MailSendingRequest request) {
        try {
            template.convertAndSend("emailMQ", mapper.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            logger.error(e.toString());
        }
    }

    //default method name is "handleMessage"
    public void handleMessage(String msgJson){
        try {
            handleRequest(mapper.readValue(msgJson, MailSendingRequest.class));
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }
}
