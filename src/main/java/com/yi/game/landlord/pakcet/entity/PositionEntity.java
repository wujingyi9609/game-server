package com.yi.game.landlord.pakcet.entity;

import com.yi.game.landlord.model.Player;
import com.yi.game.landlord.model.Room;
import lombok.Getter;

@Getter
public class PositionEntity {
    private int posId;
    private String nickname;

    public PositionEntity(Room.Position position) {
        this.posId = position.getId();
        Player player = position.getPlayer();
        this.nickname = player == null ? "" : player.getNickname();
    }
}
