package com.yi.rpc.message;

import com.yi.rpc.context.SpringContext;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class SimpleMessageDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (!in.isReadable()) {
            return;
        }
        // todo wujingyi 拆包粘包
        int msgLength = in.readInt();
        int msgId = in.readInt();
        byte[] msgData = new byte[msgLength];
        in.readBytes(msgData);
        Object message = SpringContext.getSerializer().decode(msgData);
        out.add(message);
    }
}
