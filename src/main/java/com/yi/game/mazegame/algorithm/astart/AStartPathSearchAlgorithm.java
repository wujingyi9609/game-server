package com.yi.game.mazegame.algorithm.astart;

import com.yi.game.mazegame.algorithm.PathSearchAlgorithm;
import com.yi.game.mazegame.model.Position;

import java.util.Collections;
import java.util.List;

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
        return null;
    }


}
