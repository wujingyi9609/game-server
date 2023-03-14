package com.yi.rpc.dispatcher;

import com.yi.rpc.annotation.ReqMethod;
import com.yi.rpc.constant.RPCConstant;
import com.yi.rpc.message.MessageRegistry;
import com.yi.rpc.util.ReflectionUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MessageRegister implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    private Map<Class<?>, Integer> clz2MsgId;

    @PostConstruct
    public void registerMsgId() {
        clz2MsgId = new HashMap<>(MessageRegistry.values().length);
        for (MessageRegistry message : MessageRegistry.values()) {
            Class<?> clz = message.getClz();
            int msgId = message.getMsgId();
            clz2MsgId.put(clz, msgId);
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        List<Method> methods = ReflectionUtil.getMethodWithAnno(bean, ReqMethod.class);
        for (Method method : methods) {
            tryRegisterRequestHandler(bean, method, beanName);
        }
        return bean;
    }

    private void tryRegisterRequestHandler(Object bean, Method method, String beanName) {
        int parameterCount = method.getParameterCount();
        if (parameterCount != 1) {
            throw new IllegalArgumentException("参数个数不符合要求！bean:" + beanName + ", method:" + method.getName());
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> reqClz = parameterTypes[0];
        Integer msgId = clz2MsgId.get(reqClz);
        if (msgId == null) {
            throw new IllegalArgumentException("协议未注册！bean:" + beanName + ", method:" + method.getName()
                    + ", msg:" + reqClz);
        }
        registerRequestHandler(msgId, bean, method);
    }

    private void registerRequestHandler(int msgId, Object invoker, Method method) {
        MessageDispatcher dispatcher = applicationContext.getBean(RPCConstant.MESSAGE_DISPATCHER_BEAN, MessageDispatcher.class);
        dispatcher.registerHandler(msgId, invoker, method);
    }

    public int getMsgIdOrThrow(Class<?> clz) {
        Integer msgId = clz2MsgId.get(clz);
        if (msgId == null) {
            throw new IllegalArgumentException("协议未注册！class:" + clz.getName());
        }
        return msgId;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
