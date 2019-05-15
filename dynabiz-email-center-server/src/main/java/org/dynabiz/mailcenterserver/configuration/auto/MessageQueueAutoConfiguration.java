package org.dynabiz.mailcenterserver.configuration.auto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.dynabiz.mailcenterserver.service.SendingRequestHandler;
import org.dynabiz.mailcenterserver.support.mq.AbstractMailMessageQueue;
import org.dynabiz.mailcenterserver.support.mq.RabbitMessageQueueSupport;
import org.dynabiz.mailcenterserver.support.mq.RedisMessageQueueSupport;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ConditionalOnMissingBean(AbstractMailMessageQueue.class)
public class MessageQueueAutoConfiguration {

    @ConditionalOnProperty(name = "mail-center.server.mq", havingValue = "rabbit")
    @ConditionalOnClass({ RabbitTemplate.class, Channel.class })
    @Bean
    public AbstractMailMessageQueue rabbitMqSupport(SendingRequestHandler handler){
        return new RabbitMessageQueueSupport(handler);
    }



    @Bean
    @ConditionalOnBean(StringRedisTemplate.class)
    @ConditionalOnProperty(name = "mail-center.server.mq", havingValue = "redis", matchIfMissing = true)
    public AbstractMailMessageQueue redisMqSupport(SendingRequestHandler handler, StringRedisTemplate stringRedisTemplate){
        return new RedisMessageQueueSupport(handler, stringRedisTemplate, new ObjectMapper());
    }

}


