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
    private Position targetPos;
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
    private Map<Position, AStartPosition> openPosIndex;

    public AStartContext(Position fromPos, Position targetPos) {
        this.closePositions = new HashSet<>();
        this.openPositions = new TreeSet<>();
        this.openPosIndex = new HashMap<>();
        int futureCost =  MathUtil.getDistance(fromPos, targetPos);
        AStartPosition aStartPosition = new AStartPosition(fromPos, 0, futureCost, null);
        addOpenPosition(aStartPosition);
        this.targetPos = targetPos;
    }

    public AStartPosition getMinCostPosition() {
        return openPositions.first();
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
        if (closePositions.contains(position)) {
            return;
        }
        Position realPos = position.getPosition();
        AStartPosition oldPosition = openPosIndex.get(realPos);
        int newHistoryCost = position.getHistoryCost();
        if (oldPosition != null && oldPosition.getHistoryCost() > newHistoryCost) {
            oldPosition.setHistoryCost(newHistoryCost);
            oldPosition.setPrePosition(position.getPrePosition());
            position = oldPosition;
        }
        openPositions.add(position);
        openPosIndex.put(position.getPosition(), position);
    }

}
