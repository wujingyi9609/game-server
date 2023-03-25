package com.yi.game.mazegame.algorithm.astart;

import com.yi.game.mazegame.model.Position;
import com.yi.game.mazegame.model.SearchPathResult;
import com.yi.game.util.MathUtil;
import lombok.Getter;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

@Getter
public class AStartContext {
    /**
     * 寻路结果
     */
    private SearchPathResult result = SearchPathResult.FAILED;
    /**
     * 终点
     */
    private Position toPos;
    /**
     * 无法达到终点的点
     */
    private Set<AStartPosition> closePositions;
    /**
     * 等待计算结果的点
     */
    private PriorityQueue<AStartPosition> openPositions;

    public AStartContext(Position fromPos, Position toPos) {
        this.closePositions = new HashSet<>();
        this.openPositions = new PriorityQueue<>();
        int futureCost =  MathUtil.getDistance(fromPos, toPos);
        AStartPosition aStartPosition = new AStartPosition(fromPos, 0, futureCost, null);
        this.openPositions.add(aStartPosition);
        this.toPos = toPos;
    }

    public void addClosePosition(AStartPosition pos) {
        closePositions.add(pos);
    }

    public void addOpenPositions(Set<AStartPosition> pos) {
        openPositions.addAll(pos);
    }
}
