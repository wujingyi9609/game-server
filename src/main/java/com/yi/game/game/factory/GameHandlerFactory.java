package com.yi.game.game.factory;

import com.yi.game.common.constant.GameType;
import com.yi.game.game.handler.create.AbstractCreateGameHandler;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class GameHandlerFactory {
    private Map<GameType, AbstractCreateGameHandler> createGameHandlers = new EnumMap<>(GameType.class);

    public void registerCreateGameHandler(GameType gameType, AbstractCreateGameHandler createGameHandler) {
        AbstractCreateGameHandler oldHandler = createGameHandlers.put(gameType, createGameHandler);
        if (oldHandler != null) {
            throw new IllegalArgumentException("GameType id重复！gameType:" + gameType);
        }
    }

    public AbstractCreateGameHandler getCreateGameHandler(GameType type) {
        return createGameHandlers.get(type);
    }
}
