package com.yi.game.mazegame.algorithm.astart;

import com.yi.game.mazegame.model.Position;

import java.util.List;

public class AStartPosition {
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
    private List<Position> prePositions;

    public AStartPosition(Position position, int historyCost, int futureCost, List<Position> prePositions) {
        this.position = position;
        this.historyCost = historyCost;
        this.futureCost = futureCost;
        this.prePositions = prePositions;
    }
}
