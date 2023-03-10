package com.yi.rpc.handler.messagehandler;

import com.yi.rpc.annotation.ReqMethod;
import com.yi.rpc.util.ReflectionUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.util.List;

public class ReqMessageRegister implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        List<Method> methods = ReflectionUtil.getMethodWithAnno(bean, ReqMethod.class);
        for (Method method : methods) {
            int parameterCount = method.getParameterCount();
            if (parameterCount != 1) {
                throw new IllegalArgumentException("参数个数不符合要求！bean:" + beanName + ", method:" + method.getName());
            }
        }
        return bean;
    }

    private void registerRequestHandler(int msgId, Object invoker, Method method) {
        MessageDispatcher dispatcher = applicationContext.getBean("MessageDispatcher", MessageDispatcher.class);
        dispatcher.registerHandler(msgId, invoker, method);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
