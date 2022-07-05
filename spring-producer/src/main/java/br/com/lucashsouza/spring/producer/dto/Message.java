package br.com.lucashsouza.spring.producer.dto;

public class Message {
    private String text;

    public Message() {
        // default constructor
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
