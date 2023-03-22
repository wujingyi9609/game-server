package com.yi.rpc.client;

import com.yi.rpc.constant.RPCConstant;
import com.yi.rpc.context.SpringContext;
import com.yi.rpc.example.message.SimpleReqMessage;
import io.netty.bootstrap.Bootstrap;
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
        InetSocketAddress socketAddress = new InetSocketAddress(RPCConstant.SERVER_HOST, RPCConstant.SERVER_PORT);
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class).handler(new ChannelInitializer<NioSocketChannel>() {
            protected void initChannel(NioSocketChannel ch) {
                ch.pipeline().addLast(getHandlers());
            }
        });
        NioSocketChannel channel = (NioSocketChannel)bootstrap.connect(socketAddress).sync().channel();
        if (channel.isActive()) {
            sendSimpleMsg(channel);
        }
        Thread.sleep(500L);
        group.shutdownGracefully();
        applicationContext.stop();
    }

    private static ChannelHandler[] getHandlers() {
        return SpringContext.getHandlerFactory().getClientChannelHandlers();
    }

    private static void sendSimpleMsg(NioSocketChannel channel) {
        SimpleReqMessage reqMessage = new SimpleReqMessage("Simple RPC Message!");
        channel.writeAndFlush(reqMessage);
    }
}
