package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;

/**
 * 开始
 */
public class StartingRoomState implements State<Room> {
    @Override
    public void enter(Room room) {
         notifyStart();
        // dealCards
        // randomFirstPosition
        // wait(3)
        room.getStateMachine().changeState(RoomStateType.LANDLORD_ELECTION);
    }

    private void notifyStart() {

    }

    private void dealCards() {

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
