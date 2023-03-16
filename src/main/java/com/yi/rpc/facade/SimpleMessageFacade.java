package com.yi.rpc.facade;

import com.yi.rpc.annotation.ReqMethod;
import com.yi.rpc.log.LoggerUtil;
import com.yi.rpc.message.ReqMessage;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageFacade {
    @ReqMethod
    public void handleReq(ReqMessage reqMessage) {
        LoggerUtil.info("【SimpleMessageFacade】Receive message: {}", reqMessage.getRequestContent());
    }
}
