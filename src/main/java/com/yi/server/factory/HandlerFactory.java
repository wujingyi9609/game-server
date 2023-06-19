package com.yi.server.factory;

import io.netty.channel.ChannelHandler;

public interface HandlerFactory {
    /**
     * 服务端用的ChannelHandler
     */
    ChannelHandler[] getServerChannelHandlers();

    /**
     * 客户端用的ChannelHandler
     */
    ChannelHandler[] getClientChannelHandlers();
}
