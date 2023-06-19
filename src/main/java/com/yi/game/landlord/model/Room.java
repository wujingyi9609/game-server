package com.yi.game.landlord.model;

import com.yi.game.landlord.model.poker.Poker;
import com.yi.game.landlord.statemachine.StateMachine;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 房间
 */
@Getter
@Setter
public class Room {
    private long uid;
    /**
     * 房间所有者
     */
    private Player owner;
    /**
     * 桌位
     */
    private Position[] positions;
    /**
     * 地主的牌
     */
    private List<Poker> landlordPorkers;
    /**
     * 当前需要做动作的Position下标
     */
    private int actionPosition;
    /**
     * 状态机
     */
    private StateMachine stateMachine;

    public Room(Player player) {
        owner = player;
        positions = new Position[3];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = new Position();
            positions[i].id = i;
        }
        stateMachine = new StateMachine(this);
    }

    public boolean isPlayerEnough() {
        for (Position position : positions) {
            if (position.player == null) {
                return false;
            }
        }
        return true;
    }

    public void sendToRoomPlayers(Object object) {
        for (Room.Position position : getPositions()) {
            Player player = position.getPlayer();
            if (player != null) {
                player.getSession().sendToClient(object);
            }
        }
    }

    @Getter
    public static class Position {
        private int id;
        private Player player;
    }
}
