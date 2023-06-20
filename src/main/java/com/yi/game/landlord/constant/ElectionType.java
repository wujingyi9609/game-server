package com.yi.game.landlord.constant;

import lombok.Getter;

/**
 * 抢地主状态
 */
@Getter
public enum ElectionType {
    /**
     * 抢地主
     */
    ELECTION(1),
    /**
     * 不抢
     */
    GIVE_UP(2),
    ;

    private int id;

    ElectionType(int id) {
        this.id = id;
    }
}
