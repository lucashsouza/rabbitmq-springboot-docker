package br.com.lucashsouza.spring.producer.service.implementation;

import br.com.lucashsouza.spring.producer.amqp.AmqpProducer;
import br.com.lucashsouza.spring.producer.dto.MessageQueue;
import br.com.lucashsouza.spring.producer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<MessageQueue> amqp;

    @Override
    public void sendToConsumer(MessageQueue message) {
        amqp.producer(message);
    }
}
