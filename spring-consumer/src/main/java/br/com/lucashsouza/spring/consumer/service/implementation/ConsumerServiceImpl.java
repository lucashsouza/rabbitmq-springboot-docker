package br.com.lucashsouza.spring.consumer.service.implementation;

import br.com.lucashsouza.spring.consumer.dto.MessageQueue;
import br.com.lucashsouza.spring.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(MessageQueue messageQueue) throws Exception{
        throw new Exception("Error");
//        System.out.println(message.getText());
    }
}
