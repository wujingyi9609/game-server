package com.yi.game.mazegame.algorithm;

import com.yi.game.mazegame.model.Position;

import java.util.List;

public interface PathSearchAlgorithm {
    List<Position> searchPath(Position fromPos, Position toPos);
}
