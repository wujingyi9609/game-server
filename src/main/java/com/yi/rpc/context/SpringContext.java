package com.yi.rpc.context;

import com.yi.rpc.dispatcher.MessageDispatcher;
import com.yi.rpc.dispatcher.MessageRegister;
import com.yi.rpc.factory.HandlerFactory;
import com.yi.rpc.serializer.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpringContext {
    private static SpringContext INSTANCE;

    @PostConstruct
    public void init() {
        INSTANCE = this;
    }

    @Autowired
    private MessageRegister messageRegister;

    public static MessageRegister getMessageRegister() {
        return INSTANCE.messageRegister;
    }

    @Autowired
    private Serializer serializer;

    public static Serializer getSerializer() {
        return INSTANCE.serializer;
    }

    @Autowired
    private MessageDispatcher dispatcher;

    public static MessageDispatcher getDispatcher() {
        return INSTANCE.dispatcher;
    }

    @Autowired
    private HandlerFactory handlerFactory;

    public static HandlerFactory getHandlerFactory() {
        return INSTANCE.handlerFactory;
    }
}
