package com.yi.rpc.serializer.impl;

import com.yi.rpc.message.ReqMessage;

class SimpleSerializerTest {
    public static void main(String[] args) {
        ReqMessage reqMessage = new ReqMessage("Hello Serializer");
        SimpleSerializer serializer = new SimpleSerializer();
        byte[] bytes = serializer.encode(reqMessage);
        Object obj = serializer.decode(bytes);
        System.out.println(obj);
    }
}