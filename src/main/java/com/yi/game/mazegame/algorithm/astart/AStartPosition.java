package com.yi.game.mazegame.algorithm.astart;

import com.yi.game.mazegame.model.Position;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AStartPosition that = (AStartPosition) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(AStartPosition o) {
        return Integer.compare(getTotalCost(), o.getTotalCost());
    }
}
