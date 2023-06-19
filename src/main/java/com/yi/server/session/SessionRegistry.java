package com.yi.server.session;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

public class SessionRegistry {
    private static int id = 1;
    private static ConcurrentHashMap<Integer, Session> sessions = new ConcurrentHashMap<>();
    public static void createAndRegisterSession(Channel channel) {
        int nextId = id++;
        Session session = new Session(channel);
        sessions.put(nextId, session);
    }

    public static void getSession(Channel channel) {

    }
}
