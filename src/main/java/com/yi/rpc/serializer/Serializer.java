package com.yi.rpc.serializer;

public interface Serializer {
    byte[] encode(Object object);

    Object decode(byte[] bytes);
}
