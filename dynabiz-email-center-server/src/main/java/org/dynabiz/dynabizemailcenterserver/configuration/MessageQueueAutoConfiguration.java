package org.dynabiz.dynabizemailcenterserver.configuration;

import com.rabbitmq.client.Channel;
import org.dynabiz.dynabizemailcenterserver.support.mq.EmailMessageQueue;
import org.dynabiz.dynabizemailcenterserver.support.mq.RabbitMessageQueueSupport;
import org.dynabiz.dynabizemailcenterserver.support.mq.RedisMessageQueueSupport;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisOperations;

@Configuration
public class MessageQueueAutoConfiguration {

    @ConditionalOnClass({ RabbitTemplate.class, Channel.class })
    @Bean
    public EmailMessageQueue rabbitMqSupport(){
        return new RabbitMessageQueueSupport();
    }

    @ConditionalOnClass(RedisOperations.class)
    @Bean
    public EmailMessageQueue redisMqSupport(){
        return new RedisMessageQueueSupport();
    }
}
