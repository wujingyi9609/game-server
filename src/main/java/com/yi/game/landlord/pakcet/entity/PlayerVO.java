package com.yi.game.landlord.pakcet.entity;

import com.yi.game.landlord.model.Player;
import lombok.Getter;

@Getter
public class PlayerVO {
    private int posId;
    private String nickname;

    public PlayerVO(int posId, Player player) {
        this.posId = posId;
        this.nickname = player == null ? "" : player.getNickname();
    }
}
