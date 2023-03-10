package com.yi.rpc.facade;

import com.yi.rpc.annotation.ReqMethod;
import com.yi.rpc.message.ReqMessage;
import org.springframework.stereotype.Component;

@Component
public class TestMessageFacade {
    @ReqMethod
    public void handleReq(ReqMessage reqMessage) {

    }
}
