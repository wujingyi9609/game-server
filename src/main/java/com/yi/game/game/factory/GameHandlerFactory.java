package com.yi.game.game.factory;

import com.yi.game.common.constant.GameType;
import com.yi.game.game.handler.create.CreateGameHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GameHandlerFactory {
    private Map<GameType, CreateGameHandler> createGameHandlers;

    public void registerCreateCreateHandler(GameType gameType, CreateGameHandler createGameHandler) {
        
    }
}
