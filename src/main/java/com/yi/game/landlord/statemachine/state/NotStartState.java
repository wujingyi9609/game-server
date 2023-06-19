package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.pakcet.RoomInfoResp;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;
import com.yi.game.landlord.statemachine.msg.LandlordMsgType;

/**
 * 未开始
 */
public class NotStartState implements State<Room> {
    @Override
    public void enter(Room room) {

    }

    @Override
    public void exit(Room room) {

    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void onMessage(Room room, LandlordMsg msg) {
        if (msg.getMsgType() != LandlordMsgType.ENTER_ROOM) {
            return;
        }
        notifyPlayerEnter(room);
        if (room.isPlayerEnough()) {
            room.getStateMachine().changeState(RoomStateType.STARTING);
        }
    }

    private void notifyPlayerEnter(Room room) {
        RoomInfoResp packet = new RoomInfoResp(room);
        room.sendToRoomPlayers(packet);
    }
}
