package com.yi.game.landlord.pakcet;

import com.yi.game.landlord.model.Player;
import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.pakcet.entity.PlayerVO;
import lombok.Getter;

@Getter
public class RoomInfoResp {
    private long uid;
    private PlayerVO[] positions;

    public RoomInfoResp(Room room) {
        this.uid = room.getUid();
        Player[] players = room.getPlayers();
        this.positions = new PlayerVO[players.length];
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            this.positions[i] = new PlayerVO(i, player);
        }
    }
}
