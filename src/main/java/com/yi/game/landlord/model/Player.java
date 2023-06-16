package com.yi.game.landlord.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player {
    private String nickname;

    private List<Poker> pokers;

}
