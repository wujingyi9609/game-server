package com.yi.server.serializer;

public interface Serializer {
    byte[] encode(Object object);

    Object decode(byte[] bytes);
}
