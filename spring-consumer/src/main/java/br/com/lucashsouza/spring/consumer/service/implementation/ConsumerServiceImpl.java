package br.com.lucashsouza.spring.consumer.service.implementation;

import br.com.lucashsouza.spring.consumer.dto.Message;
import br.com.lucashsouza.spring.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(Message message) {
        System.out.println(message.getText());
    }
}
