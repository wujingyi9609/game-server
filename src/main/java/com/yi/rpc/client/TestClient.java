package com.yi.rpc.client;

import com.yi.rpc.constant.RPCConstant;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class TestClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", RPCConstant.SERVER_PORT);
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class).handler(new ChannelInitializer<NioSocketChannel>() {
            protected void initChannel(NioSocketChannel ch) throws Exception {
//                ch.pipeline().addLast(new RPCMessageHandler());
            }
        });
        Channel channel = bootstrap.connect(socketAddress).sync().channel();
        if (channel.isActive()) {
            ByteBuf buffer = Unpooled.buffer();
            buffer.writeBytes("Hello RPCServer".getBytes());
            channel.writeAndFlush(buffer);
        }
        Thread.sleep(3000L);
        group.shutdownGracefully();
    }


}
