package br.com.lucashsouza.spring.consumer.amqp.implementation;

import br.com.lucashsouza.spring.consumer.amqp.AmqpConsumer;
import br.com.lucashsouza.spring.consumer.dto.MessageQueue;
import br.com.lucashsouza.spring.consumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<MessageQueue> {

    @Autowired
    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(MessageQueue messageQueue) {
        try {
            consumerService.action(messageQueue);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
