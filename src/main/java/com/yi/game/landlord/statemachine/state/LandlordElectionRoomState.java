package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;
import com.yi.game.landlord.statemachine.msg.LandlordMsgType;

public class LandlordElectionRoomState implements State<Room> {
    @Override
    public void enter(Room room) {
        // notifyPlayerElection
    }

    @Override
    public void exit(Room room) {

    }

    @Override
    public void update(Room room) {
        // checkElectionTimeout
        // notifyNextPlayerElection
    }

    @Override
    public void onMessage(Room room, LandlordMsg msg) {
        if (msg.getMsgType() != LandlordMsgType.LANDLORD_ELECT) {
            return;
        }
        // notifyNextPlayerElection
        // electionOver, selectLandlord
    }
}
