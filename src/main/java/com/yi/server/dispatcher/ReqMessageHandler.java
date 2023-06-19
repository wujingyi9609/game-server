package com.yi.server.dispatcher;

import com.yi.server.session.Session;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReqMessageHandler {
    private int messageId;
    private Object object;
    private Method method;

    public ReqMessageHandler(int messageId, Object invoker, Method method) {
        this.messageId = messageId;
        this.object = invoker;
        this.method = method;
    }

    public void invoke(Session session, Object req) {
        try {
            method.invoke(object, session, req);
        } catch (Exception e) {
            System.out.println("处理消息失败！协议ID：" + messageId + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }
}
