package br.com.lucashsouza.spring.consumer.dto;

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
