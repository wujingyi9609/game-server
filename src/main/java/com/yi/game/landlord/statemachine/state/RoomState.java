package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.statemachine.msg.LandlordMsg;
import com.yi.game.landlord.statemachine.msg.LandlordMsgType;

/**
 * 斗地主房间状态
 */
public enum RoomState implements State<Room> {
    /**
     * 未开始
     */
    NOT_START {
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
            if (room.isPlayerEnough()) {
                room.getStateMachine().changeState(RoomState.STARTING);
            }
        }
    },

    /**
     * 开始
     */
    STARTING {
        @Override
        public void enter(Room room) {
            // notifyStart
            // dealCards
            // randomFirstPosition
            // wait(3)
            room.getStateMachine().changeState(RoomState.LANDLORD_ELECTION);
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
    },

    /**
     * 抢地主
     */
    LANDLORD_ELECTION {
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
    },

    /**
     * 玩家出牌阶段
     */
    PLAYING_CARDS {
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
    },

    /**
     * 结束
     */
    END {
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
}
