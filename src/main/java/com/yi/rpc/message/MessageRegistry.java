package com.yi.rpc.message;

public enum MessageRegistry {

    REQ_MGS(-10000, ReqMessage.class, "测试请求"),
    RESP_MSG(-10001, RespMessage.class, "测试响应")
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
