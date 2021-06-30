package com.example.tictactoe.utils;

import com.example.tictactoe.model.Game;

public class GameUtils {


    public static boolean checkWinner(Game game, int row, int col){
        boolean win1 = horizontalCheck(game.getBoard()[row]);
       boolean win2 = verticalCheck(game.getBoard(), col);
      boolean win3 =   diagonalCheckOne(game.getBoard());
       boolean win4 = diagonalCheckTwo(game.getBoard());
       return win1 || win2 || win3 || win4;

    }



    private static boolean horizontalCheck(Character[] horizontalArray) {
        Character firstSymbol = horizontalArray[0];
        for (Character value : horizontalArray) {
            if(value == null) return false;
            if(firstSymbol == null) return false;
            if (!firstSymbol.equals(value)) return false;
        }
        return true;
    }

    private static boolean verticalCheck(Character[][] verticalArray, int col) {
        Character[] flattenArray = new Character[verticalArray.length];
        for (int row = 0; row < verticalArray.length; row++){
           flattenArray[row] = verticalArray[row][col];
        }
        return horizontalCheck(flattenArray);
    }

    private static boolean diagonalCheckOne(Character[][] diagonalArray) {
        Character[] flattenArray = new Character[diagonalArray.length];
        for (int row = 0; row < diagonalArray.length; row++){
            flattenArray[row] = diagonalArray[row][row];
        }
        return horizontalCheck(flattenArray);
    }

    private static boolean diagonalCheckTwo(Character[][] diagonalArray) {
        Character[] flattenArray = new Character[diagonalArray.length];
        int row = 0;
        int col = diagonalArray.length -1;
        while (row < diagonalArray.length && col >= 0){
            flattenArray[row] = diagonalArray[row][col];
            row++;
            col--;
        }
        return horizontalCheck(flattenArray);
    }

    public static boolean isBoardFull(Game game){
        for (int row = 0; row < game.getBoard().length; row++){
            for (int col = 0; col < game.getBoard()[row].length; col++){
                if(game.getBoard()[row][col] == null) return false;
            }
        }
        return true;
    }
}
