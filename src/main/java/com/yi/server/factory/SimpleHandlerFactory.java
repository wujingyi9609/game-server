package com.yi.server.factory;

import com.yi.server.example.handler.SimpleClientMessageHandler;
import com.yi.server.example.handler.SimpleMessageDecoder;
import com.yi.server.example.handler.SimpleMessageEncoder;
import com.yi.server.example.handler.SimpleServerMessageHandler;
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
