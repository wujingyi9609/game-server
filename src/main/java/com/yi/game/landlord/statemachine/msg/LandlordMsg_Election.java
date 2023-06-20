package com.yi.game.landlord.statemachine.msg;

import com.yi.game.landlord.constant.ElectionType;
import lombok.Getter;

/**
 * 抢地主 / 不抢
 */
@Getter
public class LandlordMsg_Election extends LandlordMsg {

    private ElectionType electionType;

    public LandlordMsg_Election(ElectionType electionType) {
        this.electionType = electionType;
    }
}
