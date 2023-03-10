package com.yi.rpc.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtil {
    public static List<Method> getMethodWithAnno(Object object, Class<? extends Annotation> annoClz) {
        Method[] methods = object.getClass().getMethods();
        List<Method> resultMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annoClz)) {
                resultMethods.add(method);
            }
        }
        return resultMethods;
    }
}
