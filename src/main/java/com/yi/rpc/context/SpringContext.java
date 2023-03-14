package com.yi.rpc.context;

import com.yi.rpc.dispatcher.MessageRegister;
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
}
