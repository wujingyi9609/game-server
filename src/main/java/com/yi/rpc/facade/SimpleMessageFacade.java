package com.yi.rpc.facade;

import com.yi.rpc.annotation.ReqMethod;
import com.yi.rpc.message.ReqMessage;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageFacade {
    @ReqMethod
    public void handleReq(ReqMessage reqMessage) {
        System.out.println("【SimpleMessageFacade】Receive message!");
    }
}
