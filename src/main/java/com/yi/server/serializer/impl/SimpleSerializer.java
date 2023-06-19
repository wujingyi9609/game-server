package com.yi.server.serializer.impl;

import com.yi.server.serializer.Serializer;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

/**
 * 简单的序列化实现
 * 缺点：
 * 1.序列化时附加了太多的信息
 * 2.被序列化的消息必须实现Serializable
 */
@Component
public class SimpleSerializer implements Serializer {
    @Override
    public byte[] encode(Object object) {
        return SerializationUtils.serialize(object);
    }

    @Override
    public Object decode(byte[] bytes) {
        return SerializationUtils.deserialize(bytes);
    }
}
