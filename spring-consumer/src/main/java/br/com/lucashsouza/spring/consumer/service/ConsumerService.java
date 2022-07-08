package br.com.lucashsouza.spring.consumer.service;

import br.com.lucashsouza.spring.consumer.dto.Message;

public interface ConsumerService {

    void action(Message message) throws Exception;
}
