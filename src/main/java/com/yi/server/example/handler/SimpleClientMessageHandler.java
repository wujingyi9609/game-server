package com.yi.server.example.handler;

import com.yi.server.context.SpringContext;
import com.yi.server.log.LoggerUtil;
import com.yi.server.session.Session;
import com.yi.server.session.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;

public class SimpleClientMessageHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        Attribute<Session> attr = channel.attr(SessionUtil.SESSION_ATTR_KEY);
        boolean success = attr.compareAndSet(null, new Session(channel));
        if (!success) {
            LoggerUtil.error("Session exists!");
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Channel channel = ctx.channel();
        Attribute<Session> sessionAttr = channel.attr(SessionUtil.SESSION_ATTR_KEY);
        Session session = sessionAttr.get();
        if (session == null) {
            throw new NullPointerException("Cannot find Session!");
        }
        SpringContext.getDispatcher().doHandle(session, msg);
    }
}
