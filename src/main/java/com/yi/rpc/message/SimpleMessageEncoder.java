package com.yi.rpc.message;

import com.yi.rpc.context.SpringContext;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class SimpleMessageEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        byte[] bytes = SpringContext.getSerializer().encode(o);
        int length = bytes.length;
        int msgId = SpringContext.getMessageRegister().getMsgIdOrThrow(o.getClass());
        writerByteBuffer(byteBuf, length, msgId, bytes);
    }

    private void writerByteBuffer(ByteBuf byteBuffer, int length, int msgId, byte[] bytes) {
        byteBuffer.writeInt(length);
        byteBuffer.writeInt(msgId);
        byteBuffer.writeBytes(bytes);
        System.out.println("【SimpleMessageEncoder】write buffer. length: " + length + ", msgId: " + msgId);
    }
}
