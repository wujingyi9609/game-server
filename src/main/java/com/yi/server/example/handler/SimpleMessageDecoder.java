package com.yi.server.example.handler;

import com.yi.server.context.SpringContext;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class SimpleMessageDecoder extends ByteToMessageDecoder {
    /**
     * 是否有拆包，粘包
     */
    private boolean packetFragment;
    /**
     * 协议包内容长度
     */
    private int dataLength;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (!packetFragment) {
            if (!in.isReadable(4)) {
                return;
            }
            dataLength = in.readInt();
        }
        if (in.isReadable(dataLength)) {
            int msgId = in.readInt();
            byte[] msgData = new byte[dataLength];
            in.readBytes(msgData);
            Object message = SpringContext.getSerializer().decode(msgData);
            out.add(message);
            packetFragment = false;
        }
    }
}
