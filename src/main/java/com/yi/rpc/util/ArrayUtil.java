package com.yi.rpc.util;

public class ArrayUtil {
    public boolean contains(Object[] objects, Object target) {
        for (Object object : objects) {
            if (object.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
