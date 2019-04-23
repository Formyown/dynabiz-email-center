package org.dynabiz.dynabizemailcenterserver.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.dynabiz.dynabizemailcenterserver.support.mail.MailSendingHandler;
import org.dynabiz.dynabizemailcenterserver.support.mq.AbstractMailMessageQueue;
import org.dynabiz.dynabizemailcenterserver.support.mq.RabbitMessageQueueSupport;
import org.dynabiz.dynabizemailcenterserver.support.mq.RedisMessageQueueSupport;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
@ConditionalOnMissingBean(AbstractMailMessageQueue.class)
public class MessageQueueAutoConfiguration {

    @ConditionalOnClass({ RabbitTemplate.class, Channel.class })
    @Bean
    public AbstractMailMessageQueue rabbitMqSupport(MailSendingHandler handler){
        return new RabbitMessageQueueSupport(handler);
    }





    @Configuration
    @ConditionalOnClass(RedisOperations.class)
    @ConditionalOnBean(StringRedisTemplate.class)
    public static class Redis{
        @Bean
        public AbstractMailMessageQueue redisMqSupport(MailSendingHandler handler, StringRedisTemplate stringRedisTemplate){
            return new RedisMessageQueueSupport(handler, stringRedisTemplate, new ObjectMapper());
        }

        @Bean
        RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, AbstractMailMessageQueue receiver) {

            MessageListenerAdapter listenerAdapter = new  MessageListenerAdapter(receiver);
            RedisMessageListenerContainer container = new RedisMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.addMessageListener(listenerAdapter, new PatternTopic("emailMQ"));

            return container;
        }

    }
}


