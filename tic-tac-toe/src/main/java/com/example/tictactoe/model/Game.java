package com.example.tictactoe.model;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;


@Data
public class Game {

   private String gameId;
   private Character [][] board;
   private Player player1;
   private Player player2;
   private STATE state;
   private Player turn;
   private boolean isWinner;
   private boolean isBoardFull;


    public Game() {
       board = new Character[3][3];
       gameId = RandomStringUtils.randomNumeric(4);
       state = STATE.OPEN;
       isWinner = false;
       player1 = null;
       player2 = null;
       turn = null;
    }
}
