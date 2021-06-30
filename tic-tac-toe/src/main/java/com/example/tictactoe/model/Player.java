package com.example.tictactoe.model;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

@Data
public class Player {
    private String playerId;
    private String name;
    private Character symbol;

    public Player(String name, Character symbol){
        this.name = name;
        playerId = RandomStringUtils.randomNumeric(5);
        this.symbol = symbol;
    }
}
