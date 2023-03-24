package com.yi.game.player.model;

import com.yi.game.tradegame.model.PlayerTradeGameInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 玩家实体
 */
@Getter
@Setter
public class Player {
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 交易游戏
     */
    private PlayerTradeGameInfo tradeGameInfo;
}
