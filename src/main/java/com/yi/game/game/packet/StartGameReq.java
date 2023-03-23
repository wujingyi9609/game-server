package com.yi.game.game.packet;

import lombok.Getter;

/**
 * 开始游戏请求
 */
@Getter
public class StartGameReq {
    /**
     * 游戏ID
     */
    private int gameId;

    public StartGameReq(int gameId) {
        this.gameId = gameId;
    }
}
