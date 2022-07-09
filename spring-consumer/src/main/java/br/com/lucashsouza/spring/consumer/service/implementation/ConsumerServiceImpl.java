package br.com.lucashsouza.spring.consumer.service.implementation;

import br.com.lucashsouza.spring.consumer.dto.MessageQueue;
import br.com.lucashsouza.spring.consumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(MessageQueue message) {
        if (message.getText().equalsIgnoreCase("teste")) {
            throw new AmqpRejectAndDontRequeueException("erro");
        }

        System.out.println(message.getText());
    }
}
