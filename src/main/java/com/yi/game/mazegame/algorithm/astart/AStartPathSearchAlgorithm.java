package com.yi.game.mazegame.algorithm.astart;

import com.yi.game.mazegame.algorithm.PathSearchAlgorithm;
import com.yi.game.mazegame.model.Position;
import com.yi.game.mazegame.resource.MazeResource;
import com.yi.game.util.MathUtil;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A-Start寻路算法
 */
public class AStartPathSearchAlgorithm implements PathSearchAlgorithm {
    @Override
    public List<Position> searchPath(Position fromPos, Position toPos) {
        if (fromPos == null || toPos == null) {
            return Collections.emptyList();
        }
        if (fromPos.equals(toPos)) {
            return Collections.emptyList();
        }
        AStartContext context = new AStartContext(fromPos, toPos);
        doSearchPath(context);
        return null;
    }

    private void doSearchPath(AStartContext context) {
        AStartPosition minCostPosition = context.getMinCostPosition();
        Position targetPos = context.getTargetPos();
        while (minCostPosition != null && !targetPos.equals(minCostPosition)) {
            // todo wujingyi 如何判定一个position是否close
            Set<AStartPosition> aroundPositions = createAroundPosition(minCostPosition, targetPos);
            context.addOpenPositions(aroundPositions);
        }
    }

    private Set<AStartPosition> createAroundPosition(AStartPosition position, Position targetPos) {
        Set<AStartPosition> results = new HashSet<>();
        Position realPos = position.getPosition();
        int x = realPos.getX();;
        int y = realPos.getY();
        byte[][] mapData = MazeResource.INSTANCE.getMapData();
        if (x < mapData.length - 1) {
            Position rightPosition = new Position(x + 1, y);
            int historyCost = position.getHistoryCost() + 1;
            int distance = MathUtil.getDistance(rightPosition, targetPos);
            AStartPosition aStartPosition = new AStartPosition(rightPosition, historyCost, distance, realPos);
            results.add(aStartPosition);
        }
        if (x > 0) {
            Position leftPosition = new Position(x - 1, y);
            int historyCost = position.getHistoryCost() + 1;
            int distance = MathUtil.getDistance(leftPosition, targetPos);
            AStartPosition aStartPosition = new AStartPosition(leftPosition, historyCost, distance, realPos);
            results.add(aStartPosition);
        }
        if (y < mapData[x].length - 1) {
            Position rightPosition = new Position(x, y + 1);
            int historyCost = position.getHistoryCost() + 1;
            int distance = MathUtil.getDistance(rightPosition, targetPos);
            AStartPosition aStartPosition = new AStartPosition(rightPosition, historyCost, distance, realPos);
            results.add(aStartPosition);
        }
        if (y > 0) {
            Position rightPosition = new Position(x, y - 1);
            int historyCost = position.getHistoryCost() + 1;
            int distance = MathUtil.getDistance(rightPosition, targetPos);
            AStartPosition aStartPosition = new AStartPosition(rightPosition, historyCost, distance, realPos);
            results.add(aStartPosition);
        }
        return results;
    }
}
