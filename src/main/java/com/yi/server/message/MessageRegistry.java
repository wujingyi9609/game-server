package com.yi.server.message;

import com.yi.game.landlord.pakcet.RoomInfoResp;
import com.yi.server.example.message.SimpleReqMessage;
import com.yi.server.example.message.SimpleRespMessage;

public enum MessageRegistry {

    REQ_MGS(-10000, SimpleReqMessage.class, "测试请求"),
    RESP_MSG(-10001, SimpleRespMessage.class, "测试响应"),

    LANDLORD_ROOM_INFO(-20000, RoomInfoResp.class, "房间信息"),
    ;

    /**
     * 协议ID
     */
    private int msgId;
    /**
     * 请求对象的类对象
     */
    private Class<?> clz;
    /**
     * 协议描述
     */
    private String desc;

    MessageRegistry(int msgId, Class<?> clz, String desc) {
        this.msgId = msgId;
        this.clz = clz;
        this.desc = desc;
    }

    public int getMsgId() {
        return msgId;
    }

    public Class<?> getClz() {
        return clz;
    }

    public String getDesc() {
        return desc;
    }
}
