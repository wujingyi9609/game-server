package com.yi.game.landlord.model.poker;

import com.yi.server.log.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

public class Poker {
    private static List<Poker> POKERS = createPokers();

    public static List<Poker> createPokers() {
        List<Poker> pokers = new ArrayList<>();
        for (PokerLevel pokerLevel : PokerLevel.values()) {
            if (pokerLevel == PokerLevel.BIG_JOKER || pokerLevel == PokerLevel.SMALL_JOKER) {
                pokers.add(new Poker(PokerType.JOKER, pokerLevel));
            }
            for (PokerType pokerType : PokerType.values()) {
                pokers.add(new Poker(pokerType, pokerLevel));
            }
        }
        if (pokers.size() != 54) {
            LoggerUtil.error("Poker size error! size:{}, ", pokers.size());
        }
        return pokers;
    }

    public static List<Poker> getPokers() {
        return new ArrayList<>(POKERS);
    }

    private PokerType type;
    private PokerLevel level;

    public Poker(PokerType type, PokerLevel level) {
        this.type = type;
        this.level = level;
    }
}
