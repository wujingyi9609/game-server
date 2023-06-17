package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;

public class EndRoomState implements State<Room> {
    @Override
    public void enter(Room room) {
        // kickPlayer
    }

    @Override
    public void exit(Room room) {

    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void onMessage(Room room, LandlordMsg msg) {

    }
}
