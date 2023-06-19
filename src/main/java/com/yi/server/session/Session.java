package com.yi.server.session;

import io.netty.channel.Channel;
import lombok.Getter;

import java.net.SocketAddress;

@Getter
public class Session {
    /**
     * 唯一ID
     */
    private int id;
    /**
     * 客户端channel
     */
    private Channel channel;
    /**
     * 客户端ip
     */
    private String ip;
    /**
     * 客户端端口
     */
    private int port;

    public Session(Channel channel) {
        this.channel = channel;
        SocketAddress clientAddress = channel.remoteAddress();
        String[] ipAndPort = clientAddress.toString().split(":");
        this.ip = ipAndPort[0];
        this.port = Integer.parseInt(ipAndPort[1]);
    }

    public void sendToClient(Object packet) {
        channel.writeAndFlush(packet);
    }
}
