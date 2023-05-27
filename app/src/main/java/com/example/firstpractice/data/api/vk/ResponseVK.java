package com.example.firstpractice.data.api.vk;

public class ResponseVK {
    private String text;

    public ResponseVK(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
