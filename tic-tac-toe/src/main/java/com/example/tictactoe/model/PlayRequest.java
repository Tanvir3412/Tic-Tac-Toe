package com.example.tictactoe.model;

import lombok.Data;

@Data
public class PlayRequest {

    int row;
    int col;
    String playerId;
    String gameId;

}
