package com.yi.rpc.client;

import com.yi.rpc.constant.RPCConstant;
import com.yi.rpc.message.ReqMessage;
import com.yi.rpc.message.SimpleMessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.InetSocketAddress;

public class RPCClient {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        applicationContext.start();
        Bootstrap bootstrap = new Bootstrap();
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", RPCConstant.SERVER_PORT);
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class).handler(new ChannelInitializer<NioSocketChannel>() {
            protected void initChannel(NioSocketChannel ch) {
                ch.pipeline().addLast(getSimpleHandlers());
            }
        });
        NioSocketChannel channel = (NioSocketChannel)bootstrap.connect(socketAddress).sync().channel();
        if (channel.isActive()) {
            sendSimpleMsg(channel);
        }
        Thread.sleep(1000L);
        group.shutdownGracefully();
        applicationContext.stop();
    }

    private static void sendStrMsg(Channel channel) {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeBytes("Hello RPCServer!".getBytes());
        channel.writeAndFlush(buffer);
    }

    private static ChannelHandler[] getSimpleHandlers() {
        return new ChannelHandler[]{new SimpleMessageEncoder()};
    }

    private static void sendSimpleMsg(NioSocketChannel channel) {
        ReqMessage reqMessage = new ReqMessage("Simple RPC Message!");
        channel.writeAndFlush(reqMessage);
    }
}
