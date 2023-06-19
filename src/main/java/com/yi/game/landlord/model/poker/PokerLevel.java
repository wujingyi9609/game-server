package com.yi.game.landlord.model.poker;

import lombok.Getter;

/**
 * 扑克牌大小
 */
@Getter
public enum PokerLevel {

    LEVEL_3(3, "3"),
    LEVEL_4(4, "4"),
    LEVEL_5(5, "5"),
    LEVEL_6(6, "6"),
    LEVEL_7(7, "7"),
    LEVEL_8(8, "8"),
    LEVEL_9(9, "9"),
    LEVEL_10(10, "10"),
    LEVEL_11(11, "J"),
    LEVEL_12(12, "Q"),
    LEVEL_13(13, "K"),
    LEVEL_A(14, "A"),
    LEVEL_2(15, "2"),
    SMALL_JOKER(16, "SMALL_JOKER"),
    BIG_JOKER(17, "BIG_JOKER"),
    ;

    private int level;
    private String name;

    PokerLevel(int level, String name) {
        this.level = level;
        this.name = name;
    }
}
