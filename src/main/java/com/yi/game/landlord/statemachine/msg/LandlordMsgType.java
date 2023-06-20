package com.yi.game.landlord.statemachine.msg;

public enum LandlordMsgType {
    /**
     * 进入房间
     */
    ENTER_ROOM,
    /**
     * 离开房间
     */
    LEAVE_ROOM,
    /**
     * 抢地主
     */
    LANDLORD_ELECTION,
    /**
     * 出牌
     */
    PLAY_CARD,
}
