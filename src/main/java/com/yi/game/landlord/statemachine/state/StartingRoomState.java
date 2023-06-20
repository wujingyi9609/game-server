package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.model.poker.Poker;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;
import com.yi.game.landlord.util.PokerUtil;
import com.yi.server.util.RandomUtil;

import java.util.List;

/**
 * 开始
 */
public class StartingRoomState implements State<Room> {
    @Override
    public void enter(Room room) {
        distributePokers(room);
        randomFirstPosition(room);
        room.getStateMachine().changeState(RoomStateType.LANDLORD_ELECTION);
    }

    private void distributePokers(Room room) {
        List<List<Poker>> playerPokers = PokerUtil.distributePorkers();
        for (int i = 0; i < room.getPlayers().length; i++) {
            List<Poker> pokers = playerPokers.get(i);
            room.getPlayers()[i].setPokers(pokers);
        }
        room.setLandlordPorkers(playerPokers.get(3));
    }

    private void randomFirstPosition(Room room) {
        int firstIndex = RandomUtil.randomInt(0, 3);
        room.setActionPosition(firstIndex);
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
