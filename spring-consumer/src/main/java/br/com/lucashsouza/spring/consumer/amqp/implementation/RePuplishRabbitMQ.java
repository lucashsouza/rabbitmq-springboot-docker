package br.com.lucashsouza.spring.consumer.amqp.implementation;

import br.com.lucashsouza.spring.consumer.amqp.AmqpRePublish;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class RePuplishRabbitMQ implements AmqpRePublish {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String X_RETRIES_HEADER = "x-retries";
    private static final int NUMERO_MAXIMO_TENTATIVAS = 3;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String routingKey;

    @Value("${spring.rabbitmq.request.dead-letter.producer}")
    private String deadLetter;

    @Value("${spring.rabbitmq.request.parking-lot.producer}")
    private String parkingLot;


    @Override
    @Scheduled(cron = "${spring.rabbitmq.listener.time-retry}")
    public void rePublish() {
        List<Message> messages = getQueueMessages();

        for (Message message : messages) {
            Map<String, Object> headers = message.getMessageProperties().getHeaders();
            Integer retriesHeader = (Integer) headers.get(X_RETRIES_HEADER);

            if (retriesHeader == null) {
                retriesHeader = 0;
            }

            if (retriesHeader < NUMERO_MAXIMO_TENTATIVAS) {
                headers.put(X_RETRIES_HEADER, retriesHeader + 1);
                rabbitTemplate.send(exchange, routingKey, message);
            } else {
                rabbitTemplate.send(parkingLot, message);
            }
        }
    }

    private List<Message> getQueueMessages() {
        List<Message> messages = new ArrayList<>();
        Boolean isNull;
        Message message;

        do {
            message = rabbitTemplate.receive(deadLetter);
            isNull = message != null;

            if (Boolean.TRUE.equals(isNull)) {
                messages.add(message);
            }
        } while (isNull.equals(Boolean.TRUE));

        return messages;
    }
}
