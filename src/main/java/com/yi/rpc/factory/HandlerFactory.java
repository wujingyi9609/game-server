package com.yi.rpc.factory;

import io.netty.channel.ChannelHandler;

public interface HandlerFactory {
    ChannelHandler[] getChannelHandlers();
}
