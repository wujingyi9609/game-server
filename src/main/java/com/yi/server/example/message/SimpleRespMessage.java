package com.yi.server.example.message;

import java.io.Serializable;

public class SimpleRespMessage implements Serializable {
    private String respContent;

    public SimpleRespMessage(String respContent) {
        this.respContent = respContent;
    }

    @Override
    public String toString() {
        return "RespMessage{" +
                "respContent='" + respContent + '\'' +
                '}';
    }
}
