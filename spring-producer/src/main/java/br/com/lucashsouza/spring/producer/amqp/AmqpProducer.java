package br.com.lucashsouza.spring.producer.amqp;

public interface AmqpProducer<T> {
    void producer(T t);
}
