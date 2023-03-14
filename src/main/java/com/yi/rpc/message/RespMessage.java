package com.yi.rpc.message;

import java.io.Serializable;

public class RespMessage implements Serializable {
    private String respContent;

    public RespMessage(String respContent) {
        this.respContent = respContent;
    }
}
