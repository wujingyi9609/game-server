package com.yi.game.util;

import com.yi.game.mazegame.model.Position;

public class MathUtil {
    public static int getDistance(Position pos1, Position pos2) {
        return Math.abs(pos2.getX() - pos1.getX()) + Math.abs(pos2.getY() - pos1.getY());
    }
}
