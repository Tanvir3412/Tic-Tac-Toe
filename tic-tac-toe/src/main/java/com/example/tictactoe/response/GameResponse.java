package com.example.tictactoe.response;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.Player;
import com.example.tictactoe.model.STATE;
import lombok.Data;

import java.util.UUID;

@Data
public class GameResponse {
   private String gameId;
   private Character [][] board;
   private Player player1;
   private Player player2;
   private STATE state;
   private Player turn;
   private boolean isWinner;
   private boolean isBoardFull;

    public GameResponse(Game game){
        gameId = game.getGameId();
        board = game.getBoard();
        player1 = game.getPlayer1();
        player2 = game.getPlayer2();
        state = game.getState();
        turn = game.getTurn();
        isWinner = game.isWinner();
        isBoardFull = game.isBoardFull();
    }
}
