package com.yi.rpc.example.message;

import java.io.Serializable;

public class SimpleReqMessage implements Serializable {
    private String requestContent;

    public SimpleReqMessage(String requestContent) {
        this.requestContent = requestContent;
    }

    public String getRequestContent() {
        return requestContent;
    }
}
