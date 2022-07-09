package br.com.lucashsouza.spring.consumer.service;

import br.com.lucashsouza.spring.consumer.dto.MessageQueue;

public interface ConsumerService {

    void action(MessageQueue message);
}
