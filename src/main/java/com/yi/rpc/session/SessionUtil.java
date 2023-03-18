package com.yi.rpc.session;

import io.netty.util.AttributeKey;

public class SessionUtil {
    public static final AttributeKey<Session> SESSION_ATTR_KEY = AttributeKey.valueOf("SESSION_ATTR_KEY");
}
