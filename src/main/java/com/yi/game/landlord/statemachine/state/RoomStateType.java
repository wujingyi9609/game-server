package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.model.Room;

/**
 * 斗地主房间状态
 */
public enum RoomStateType {

    /**
     * 未开始
     */
    NOT_START(new NotStartState()),

    /**
     * 开始
     */
    STARTING(new StartingRoomState()),

    /**
     * 抢地主
     */
    LANDLORD_ELECTION(new LandlordElectionRoomState()),

    /**
     * 玩家出牌阶段
     */
    PLAYING_CARDS(new PlayCardRoomState()),

    /**
     * 结束
     */
    END(new EndRoomState());

    private State<Room> roomState;

    RoomStateType(State<Room> roomState) {
        this.roomState = roomState;
    }

    public State<Room> getRoomState() {
        return roomState;
    }
}
