package com.yi.rpc.facade;

import com.yi.rpc.annotation.ReqMethod;
import com.yi.rpc.log.LoggerUtil;
import com.yi.rpc.message.ReqMessage;
import com.yi.rpc.message.RespMessage;
import com.yi.rpc.session.Session;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageFacade {
    @ReqMethod
    public void handleReq(Session session, ReqMessage reqMessage) {
        session.sendToClient(new RespMessage("This is RespMessage!"));
        LoggerUtil.info("【SimpleMessageFacade】Receive message: {}", reqMessage.getRequestContent());
    }
}
