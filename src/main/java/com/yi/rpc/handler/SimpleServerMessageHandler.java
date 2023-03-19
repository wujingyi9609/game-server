package com.yi.rpc.handler;

import com.yi.rpc.log.LoggerUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleServerMessageHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LoggerUtil.info("【SimpleServerMessageHandler】 Receive message: {}", msg);
    }
}
