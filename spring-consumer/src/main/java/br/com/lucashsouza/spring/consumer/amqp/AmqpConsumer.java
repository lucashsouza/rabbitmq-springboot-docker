package br.com.lucashsouza.spring.consumer.amqp;

public interface AmqpConsumer<T> {

    void consumer(T t);
}
