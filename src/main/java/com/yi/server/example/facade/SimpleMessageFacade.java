package com.yi.server.example.facade;

import com.yi.server.annotation.ReqMethod;
import com.yi.server.example.message.SimpleReqMessage;
import com.yi.server.example.message.SimpleRespMessage;
import com.yi.server.log.LoggerUtil;
import com.yi.server.session.Session;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageFacade {
    @ReqMethod
    public void handleReq(Session session, SimpleReqMessage reqMessage) {
        session.sendToClient(new SimpleRespMessage("This is RespMessage!"));
        LoggerUtil.info("【SimpleMessageFacade】Receive message: {}", reqMessage.getRequestContent());
    }
}
