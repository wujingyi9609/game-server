package com.yi.game.landlord.statemachine;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;
import com.yi.game.landlord.statemachine.state.RoomStateType;
import com.yi.game.landlord.statemachine.state.State;

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
    private State<Room> curState;

    public StateMachine(Room room) {
        this.room = room;
        this.curState = RoomStateType.NOT_START.getRoomState();
    }

    void onMessage(LandlordMsg msg) {
        curState.onMessage(room, msg);
    }

    public void changeState(RoomStateType stateType) {
        curState.exit(room);
        curState = stateType.getRoomState();
        curState.enter(room);
    }
}
