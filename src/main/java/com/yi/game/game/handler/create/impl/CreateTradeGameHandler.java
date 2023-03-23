package com.yi.game.game.handler.create.impl;

import com.yi.game.common.constant.GameType;
import com.yi.game.game.handler.create.AbstractCreateGameHandler;
import com.yi.game.player.model.Player;
import org.springframework.stereotype.Component;

@Component
public class CreateTradeGameHandler extends AbstractCreateGameHandler {
    @Override
    public GameType getType() {
        return GameType.TRADE;
    }

    @Override
    public void create(Player player) {

    }
}
