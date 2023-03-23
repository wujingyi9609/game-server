package com.yi.game.game.handler;

import com.yi.game.common.constant.GameType;
import com.yi.game.game.factory.GameHandlerFactory;
import com.yi.game.game.handler.create.AbstractCreateGameHandler;
import com.yi.game.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartGameHandler {
    @Autowired
    private GameHandlerFactory handlerFactory;

    public void startGame(Player player, int gameType) {
        AbstractCreateGameHandler createGameHandler = handlerFactory.getCreateGameHandler(GameType.valueOf(gameType));
        createGameHandler.create(player);
    }
}
