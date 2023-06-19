package com.yi.game.landlord.pakcet;

import lombok.Getter;

/**
 * 告诉玩家可以进行抢地主
 */
@Getter
public class ElectionNotifyResp {
    /**
     * 当前在抢地主的位置
     */
    private int curElectionPos;
    /**
     * 抢地主倒计时
     */
    private int countDownSec;

    public ElectionNotifyResp(int curElectionPos, int countDownSec) {
        this.curElectionPos = curElectionPos;
        this.countDownSec = countDownSec;
    }
}
