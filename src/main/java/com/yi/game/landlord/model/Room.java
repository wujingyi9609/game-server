package com.yi.game.landlord.model;

import com.yi.game.landlord.statemachine.StateMachine;
import lombok.Getter;

/**
 * 房间
 */
@Getter
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
     * 当前需要做动作的Position下标
     */
    private int curIndex;
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

    private static class Position {
        private int id;
        private Player player;
    }
}
