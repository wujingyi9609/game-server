package com.yi.game.landlord.statemachine;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;
import com.yi.game.landlord.statemachine.state.RoomState;

/**
 * 状态机，负责状态切换
 */
public class StateMachine {
    /**
     * 状态机负责的房间
     */
    private Room room;
    /**
     * 当前状态
     */
    private RoomState curState;

    public StateMachine(Room room) {
        this.room = room;
        this.curState = RoomState.NOT_START;
    }

    void onMessage(LandlordMsg msg) {
        curState.onMessage(room, msg);
    }

    public void changeState(RoomState newState) {
        curState.exit(room);
        curState = newState;
        newState.enter(room);
    }
}
