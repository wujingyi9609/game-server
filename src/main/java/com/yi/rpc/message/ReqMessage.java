package com.yi.rpc.message;

import java.io.Serializable;

public class ReqMessage implements Serializable {
    private String requestContent;

    public ReqMessage(String requestContent) {
        this.requestContent = requestContent;
    }
}
