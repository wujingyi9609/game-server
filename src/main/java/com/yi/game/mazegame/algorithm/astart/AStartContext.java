package com.yi.game.mazegame.algorithm.astart;

import com.yi.game.mazegame.model.Position;
import com.yi.game.mazegame.model.SearchPathResult;
import com.yi.game.util.MathUtil;
import lombok.Getter;

import java.util.*;

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
     * 等待计算结果的坐标
     */
    private SortedSet<AStartPosition> openPositions;
    /**
     * 坐标：坐标信息
     */
    private Map<Position, AStartPosition> openPosCache;

    public AStartContext(Position fromPos, Position toPos) {
        this.closePositions = new HashSet<>();
        this.openPositions = new TreeSet<>();
        int futureCost =  MathUtil.getDistance(fromPos, toPos);
        AStartPosition aStartPosition = new AStartPosition(fromPos, 0, futureCost, null);
        this.openPositions.add(aStartPosition);
        this.toPos = toPos;
    }

    public void addClosePosition(AStartPosition pos) {
        closePositions.add(pos);
    }

    public void addOpenPositions(Set<AStartPosition> positions) {
        for (AStartPosition position : positions) {
            addOpenPosition(position);
        }
    }

    private void addOpenPosition(AStartPosition position) {
        Position realPos = position.getPosition();
        AStartPosition oldPosition = openPosCache.get(realPos);
        int newHistoryCost = position.getHistoryCost();
        if (oldPosition != null && oldPosition.getHistoryCost() > newHistoryCost) {
            oldPosition.setHistoryCost(newHistoryCost);
            oldPosition.setPrePosition(position.getPrePosition());
        }
    }

}
