package com.yi.game.landlord.model;

import com.yi.game.landlord.constant.ElectionType;
import com.yi.game.landlord.model.poker.Poker;
import com.yi.server.session.Session;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player {
    private Session session;

    private String nickname;

    private PlayerType playerType;

    private ElectionType electionType;

    private long timeOutMs;

    private List<Poker> pokers;


    public Player(Session session) {
        this.session = session;
    }
}
