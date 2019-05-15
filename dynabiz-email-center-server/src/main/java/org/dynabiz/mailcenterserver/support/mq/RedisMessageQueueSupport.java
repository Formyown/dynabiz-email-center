package org.dynabiz.mailcenterserver.support.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dynabiz.mailcenterserver.service.SendingRequestHandler;
import org.dynabiz.mailcenterserver.vos.MailSendingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;

public class RedisMessageQueueSupport extends AbstractMailMessageQueue {
    public static final String DEFAULT_NAMESPACE = "mail:queue";
    private static final Logger logger = LoggerFactory.getLogger(RedisMessageQueueSupport.class);



    private StringRedisTemplate template;
    private ObjectMapper mapper;


    public RedisMessageQueueSupport(SendingRequestHandler handler, StringRedisTemplate template,
                                    ObjectMapper mapper) {
        super(handler);
        this.template = template;
        this.mapper = mapper;
        ListenerThread listenerThread = new ListenerThread(template, this);
        listenerThread.start();
    }

    @Override
    public void push(MailSendingRequest request) {
        try {
            template.convertAndSend("emailMQ", mapper.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            logger.error(e.toString());
        }
    }

    public void handleMessage(String msgJson){
        try {
            handleRequest(mapper.readValue(msgJson, MailSendingRequest.class));
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }


    public static class ListenerThread extends Thread{
        private StringRedisTemplate template;
        private RedisMessageQueueSupport support;
        ListenerThread(StringRedisTemplate template, RedisMessageQueueSupport support) {
            this.template = template;
            this.support = support;
        }

        @Override
        public void run() {
            while (true){
                String reqJson = template.opsForList().rightPop(DEFAULT_NAMESPACE);
                if (reqJson == null) continue;
                support.handleMessage(reqJson);
            }

        }
    }
}
