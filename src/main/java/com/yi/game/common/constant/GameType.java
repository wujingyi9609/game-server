package com.yi.game.common.constant;

/**
 * 游戏类型
 */
public enum GameType {
    /**
     * 交易游戏
     */
    TRADE(1),
    ;

    /**
     * 游戏ID
     */
    private int id;

    GameType(int id) {
        this.id = id;
    }

    public static GameType valueOf(int id) {
        for (GameType gameType : values()) {
            if (gameType.id == id) {
                return gameType;
            }
        }
        return null;
    }
}
