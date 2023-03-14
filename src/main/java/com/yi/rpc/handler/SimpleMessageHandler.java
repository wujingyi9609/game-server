package com.yi.rpc.handler;

import com.yi.rpc.context.SpringContext;
import com.yi.rpc.dispatcher.ReqMessageHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleMessageHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        int msgId = SpringContext.getMessageRegister().getMsgIdOrThrow(msg.getClass());
        ReqMessageHandler messageHandler = SpringContext.getDispatcher().getMsgHandlerThrow(msgId);
        messageHandler.invoke(msg);
    }
}
