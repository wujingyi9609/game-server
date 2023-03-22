package com.yi.rpc.example.facade;

import com.yi.rpc.annotation.ReqMethod;
import com.yi.rpc.example.message.SimpleReqMessage;
import com.yi.rpc.example.message.SimpleRespMessage;
import com.yi.rpc.log.LoggerUtil;
import com.yi.rpc.session.Session;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageFacade {
    @ReqMethod
    public void handleReq(Session session, SimpleReqMessage reqMessage) {
        session.sendToClient(new SimpleRespMessage("This is RespMessage!"));
        LoggerUtil.info("【SimpleMessageFacade】Receive message: {}", reqMessage.getRequestContent());
    }
}
