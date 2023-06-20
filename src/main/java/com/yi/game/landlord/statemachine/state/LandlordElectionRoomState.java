package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.constant.ElectionType;
import com.yi.game.landlord.constant.PokerConst;
import com.yi.game.landlord.model.Player;
import com.yi.game.landlord.model.PlayerType;
import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.pakcet.ElectionNotifyResp;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;
import com.yi.game.landlord.statemachine.msg.LandlordMsgType;
import com.yi.game.landlord.statemachine.msg.LandlordMsg_Election;

public class LandlordElectionRoomState implements State<Room> {
    @Override
    public void enter(Room room) {
        notifyPlayerElection(room);
    }

    private void notifyPlayerElection(Room room) {
        int actionPosition = room.getActionPosition();
        ElectionNotifyResp packet = new ElectionNotifyResp(actionPosition, PokerConst.ELECTION_SECONDS);
        room.sendToRoomPlayers(packet);
    }

    @Override
    public void exit(Room room) {
        selectLandlord(room);
    }

    private void selectLandlord(Room room) {
        Player actionPlayer = room.getActionPlayer();
        while (true) {
            if (actionPlayer.getElectionType() == ElectionType.ELECTION || actionPlayer.getPlayerType() == PlayerType.FARMER) {
                actionPlayer.setPlayerType(PlayerType.LANDLORD);
                return;
            } else {
                actionPlayer.setPlayerType(PlayerType.FARMER);
                room.updateActionPos();
            }
        }
    }

    @Override
    public void update(Room room) {
        if (room.isCurActionTimeout()) {
            Player actionPlayer = room.getActionPlayer();
            actionPlayer.setElectionType(ElectionType.GIVE_UP);
            room.updateActionPos();
            updateState(room);
        }
    }

    @Override
    public void onMessage(Room room, LandlordMsg msg) {
        if (msg.getMsgType() != LandlordMsgType.LANDLORD_ELECTION) {
            return;
        }
        LandlordMsg_Election electionMsg = (LandlordMsg_Election) msg;
        ElectionType electionType = electionMsg.getElectionType();
        room.getActionPlayer().setElectionType(electionType);
        room.updateActionPos();
        updateState(room);
    }

    private void updateState(Room room) {
        RoomStateType nextState = room.isElectionOver() ? RoomStateType.STARTING : RoomStateType.LANDLORD_ELECTION;
        room.getStateMachine().changeState(nextState);
    }
}
