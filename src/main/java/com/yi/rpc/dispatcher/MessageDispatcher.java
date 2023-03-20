package com.yi.rpc.dispatcher;

import com.yi.rpc.constant.RPCConstant;
import com.yi.rpc.context.SpringContext;
import com.yi.rpc.session.Session;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 协议分发器，将收到的不同协议分发到对应的处理器
 */
@Component(RPCConstant.MESSAGE_DISPATCHER_BEAN_NAME)
public class MessageDispatcher {
    private Map<Integer, ReqMessageHandler> messageHandlers = new HashMap<>();
    private ThreadPoolExecutor[] executors = new ThreadPoolExecutor[RPCConstant.EXECUTOR_NUM];

    @PostConstruct
    public void postConstruct() {
        for (int i = 0; i < executors.length; i++) {
            int index = i;
            executors[i] = new ThreadPoolExecutor(1, 1, 300, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(), new DefaultThreadFactory("core-executor-" + index));
        }
    }

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

    public void doHandle(Session session, Object msg) {
        int sessionId = session.getId();
        executors[sessionId % executors.length].submit(new Runnable() {
            @Override
            public void run() {
                int msgId = SpringContext.getMessageRegister().getMsgIdOrThrow(msg.getClass());
                ReqMessageHandler handler = getMsgHandlerThrow(msgId);
                handler.invoke(session, msg);
            }
        });
    }
}
