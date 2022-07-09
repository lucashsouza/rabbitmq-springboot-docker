package br.com.lucashsouza.spring.producer.service;

import br.com.lucashsouza.spring.producer.dto.MessageQueue;

public interface AmqpService {
    void sendToConsumer(MessageQueue message);
}
