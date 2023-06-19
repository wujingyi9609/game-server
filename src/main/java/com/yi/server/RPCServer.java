package com.yi.server;

import com.yi.server.constant.RPCConstant;
import com.yi.server.context.SpringContext;
import com.yi.server.example.handler.PrintMessageHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class RPCServer {
    private EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private EventLoopGroup workerGroup = new NioEventLoopGroup(4);

    public void start() {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup).childOption(ChannelOption.TCP_NODELAY, true)
                .channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel channel) throws Exception {
                         channel.pipeline().addLast(getHandlers());
                    }
                }).bind(RPCConstant.SERVER_PORT);
    }

    public void shutdown() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    private ChannelHandler[] getPrintHandlers() {
        return new ChannelHandler[]{new PrintMessageHandler()};
    }

    private ChannelHandler[] getHandlers() {
        return SpringContext.getHandlerFactory().getServerChannelHandlers();
    }
}
