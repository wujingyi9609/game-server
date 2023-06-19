package com.yi.game.landlord.util;

import com.yi.game.landlord.model.poker.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerUtil {
    public static List<List<Poker>> distributePorkers() {
        List<List<Poker>> result = new ArrayList<>();
        List<Poker> pokers = Poker.getPokers();
        Collections.shuffle(pokers);
        result.add(pokers.subList(0, 17));
        result.add(pokers.subList(17, 34));
        result.add(pokers.subList(34, 51));
        result.add(pokers.subList(51, 54));
        return result;
    }
}
