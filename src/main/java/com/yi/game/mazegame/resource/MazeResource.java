package com.yi.game.mazegame.resource;

import lombok.Getter;

@Getter
public class MazeResource {
    public static final MazeResource INSTANCE = new MazeResource();

    private byte[][] mapData = new byte[][] {
            new byte[]{0, 0, 0, 0, 0},
            new byte[]{0, 0, 0, 0, 0},
            new byte[]{0, 0, 1, 0, 0},
            new byte[]{0, 0, 1, 0, 0},
            new byte[]{0, 0, 1, 0, 0},
    };
}
