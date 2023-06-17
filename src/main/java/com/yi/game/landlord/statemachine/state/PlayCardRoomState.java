package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;
import com.yi.game.landlord.statemachine.msg.LandlordMsgType;

public class PlayCardRoomState implements State<Room> {
    @Override
    public void enter(Room room) {
        // notifyPlayerToPlayCard
    }

    @Override
    public void exit(Room room) {

    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void onMessage(Room room, LandlordMsg msg) {
        if (msg.getMsgType() != LandlordMsgType.PLAY_CARD) {
            return;
        }
        // checkWin()
        // notifyNextPlayerToPlayCard
    }
}
