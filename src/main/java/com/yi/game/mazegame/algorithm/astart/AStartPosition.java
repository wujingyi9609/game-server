package com.yi.game.mazegame.algorithm.astart;

import com.yi.game.mazegame.model.Position;

public class AStartPosition implements Comparable<AStartPosition> {
    /**
     * 当前位置
     */
    private Position position;
    /**
     * 起点走到这里的消耗
     */
    private int historyCost;
    /**
     * 当前点到终点的消耗
     */
    private int futureCost;
    /**
     * 前置点
     */
    private Position prePosition;

    public AStartPosition(Position position, int historyCost, int futureCost, Position prePosition) {
        this.position = position;
        this.historyCost = historyCost;
        this.futureCost = futureCost;
        this.prePosition = prePosition;
    }

    public int getTotalCost() {
        return historyCost + futureCost;
    }

    @Override
    public int compareTo(AStartPosition o) {
        return Integer.compare(getTotalCost(), o.getTotalCost());
    }
}
