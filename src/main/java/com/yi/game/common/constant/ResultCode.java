package com.yi.game.common.constant;

public enum ResultCode {

    ;

    /**
     * 结果码
     */
    private int code;
    /**
     * 消息
     */
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
