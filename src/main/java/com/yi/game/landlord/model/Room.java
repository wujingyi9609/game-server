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
     * 各个桌位的玩家
     */
    private Player[] players;
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
        players = new Player[3];
        stateMachine = new StateMachine(this);
    }

    public void updateActionPos() {
        actionPosition = (actionPosition + 1) % 3;
    }

    public void update() {
        stateMachine.getCurState().update(this);
    }

    public void sendToRoomPlayers(Object object) {
        for (Player player : this.getPlayers()) {
            if (player != null) {
                player.getSession().sendToClient(object);
            }
        }
    }

    public boolean isPlayerEnough() {
        for (Player player : players) {
            if (player == null) {
                return false;
            }
        }
        return true;
    }

    public Player getActionPlayer() {
        return players[actionPosition];
    }

    public boolean isCurActionTimeout() {
        Player player = players[actionPosition];
        return System.currentTimeMillis() > player.getTimeOutMs();
    }

    /**
     * 抢地主阶段是否结束
     */
    public boolean isElectionOver() {
        for (Player player : players) {
            if (player.getElectionType() == null) {
                return false;
            }
        }
        return true;
    }
}
