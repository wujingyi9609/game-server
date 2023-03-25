package com.yi.game.mazegame.algorithm.astart;

import com.yi.game.mazegame.model.Position;

import java.util.PriorityQueue;
import java.util.Set;

public class AStartContext {
    private Set<Position> closePositions;
    private PriorityQueue<Position> openPositions;
}
