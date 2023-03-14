package com.yi.rpc.dispatcher;

import com.yi.rpc.constant.RPCConstant;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 协议分发器，将收到的不同协议分发到对应的处理器
 */
@Component(RPCConstant.MESSAGE_DISPATCHER_BEAN)
public class MessageDispatcher {
    private Map<Integer, ReqMessageHandler> messageHandlers = new HashMap<>();

    public void registerHandler(int messageId, Object invoker, Method method) {
        ReqMessageHandler msgHandler = new ReqMessageHandler(messageId, invoker, method);
        ReqMessageHandler oldHandler = messageHandlers.put(messageId, msgHandler);
        if (oldHandler != null) {
            throw new UnsupportedOperationException("协议号重复！id：" +  messageId);
        }
    }

    public ReqMessageHandler getMsgHandlerThrow(int msgId) {
        ReqMessageHandler messageHandler = messageHandlers.get(msgId);
        if (messageHandler == null) {
            throw new IllegalArgumentException("找不到协议处理器！id：" + msgId);
        }
        return messageHandler;
    }
}
