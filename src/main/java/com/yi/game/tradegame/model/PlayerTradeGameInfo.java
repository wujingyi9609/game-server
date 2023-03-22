package com.yi.game.tradegame.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 玩家交易信息
 */
@Getter
@Setter
public class PlayerTradeGameInfo {
    /**
     * 拥有货币数量
     */
    private int coin;
    /**
     * 拥有的商品ID:数量
     */
    private Map<Integer, Integer> item2Num;
}
