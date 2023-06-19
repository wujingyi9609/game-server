package com.yi.game.landlord.pakcet;

import com.yi.game.landlord.model.Room;
import com.yi.game.landlord.pakcet.entity.PositionEntity;
import lombok.Getter;

@Getter
public class RoomInfoResp {
    private long uid;
    private PositionEntity[] positions;

    public RoomInfoResp(Room room) {
        this.uid = room.getUid();
        Room.Position[] roomPositions = room.getPositions();
        this.positions = new PositionEntity[roomPositions.length];
        for (int i = 0; i < roomPositions.length; i++) {
            Room.Position roomPosition = roomPositions[i];
            this.positions[i] = new PositionEntity(roomPosition);
        }
    }
}
