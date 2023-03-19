package com.yi.rpc.factory;

import com.yi.rpc.handler.SimpleClientMessageHandler;
import com.yi.rpc.handler.SimpleMessageDecoder;
import com.yi.rpc.handler.SimpleMessageEncoder;
import com.yi.rpc.handler.SimpleServerMessageHandler;
import io.netty.channel.ChannelHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleHandlerFactory implements HandlerFactory {
    @Override
    public ChannelHandler[] getServerChannelHandlers() {
        return new ChannelHandler[]{new SimpleMessageDecoder(), new SimpleClientMessageHandler(), new SimpleMessageEncoder()};
    }

    @Override
    public ChannelHandler[] getClientChannelHandlers() {
        return new ChannelHandler[]{new SimpleMessageDecoder(), new SimpleServerMessageHandler(), new SimpleMessageEncoder()};
    }
}
