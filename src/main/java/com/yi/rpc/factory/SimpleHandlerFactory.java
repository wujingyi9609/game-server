package com.yi.rpc.factory;

import com.yi.rpc.handler.SimpleMessageHandler;
import com.yi.rpc.handler.SimpleMessageDecoder;
import com.yi.rpc.handler.SimpleMessageEncoder;
import io.netty.channel.ChannelHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleHandlerFactory implements HandlerFactory {
    @Override
    public ChannelHandler[] getChannelHandlers() {
        return new ChannelHandler[]{new SimpleMessageDecoder(), new SimpleMessageHandler(), new SimpleMessageEncoder()};
    }
}
