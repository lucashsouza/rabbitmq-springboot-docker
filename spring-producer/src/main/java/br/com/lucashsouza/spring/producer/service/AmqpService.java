package br.com.lucashsouza.spring.producer.service;

import br.com.lucashsouza.spring.producer.dto.Message;

public interface AmqpService {
    void sendToConsumer(Message message);
}
