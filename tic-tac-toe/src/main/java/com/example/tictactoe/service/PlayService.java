package com.example.tictactoe.service;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.PlayRequest;
import com.example.tictactoe.model.STATE;
import com.example.tictactoe.response.GameResponse;
import com.example.tictactoe.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayService {

    @Autowired
    GameService gameService;

    // game - player1, player2, turn, board
    // board - row , col
    // player1  - name = tanvir, symbol = x, id = 3333
    // player2 - name = jahangir, symbol = 0, id = 2894;
    // turn -  name = jahangir, symbol = x, id = 2894

    // player1request - row-0, col -0, playerId - 3333, gameId - 3444
    // player2request - row-0, col -1, playerId - 2894, gameId - 3444

    public GameResponse play(PlayRequest playRequest) {
         Game game = gameService.gameMap.get(playRequest.getGameId());
        // check is there a game
        if(game == null ) return null;
        // is your turn and is spot open or empty
        if(game.getTurn().getPlayerId().equals(playRequest.getPlayerId()) && game.getBoard()[playRequest.getRow()][playRequest.getCol()] == null){
            game.getBoard()[playRequest.getRow()][playRequest.getCol()] = game.getTurn().getSymbol();    // i have problem here to understand

                                                                                                        // now i got it
            // update turn to player2
            updatePlayerTurn(game);

        }

        boolean checkWinner = GameUtils.checkWinner(game, playRequest.getRow(), playRequest.getCol());
        if(checkWinner) {
            game.setWinner(true);
            game.setState(STATE.CLOSED);
            return new GameResponse(game);
        }

        return new GameResponse(game);
    }

    private void updatePlayerTurn(Game game) {
        if(game.getTurn().getPlayerId().equals(game.getPlayer1().getPlayerId())){
            game.setTurn(game.getPlayer2());
        } else {
            game.setTurn(game.getPlayer1());
        }
    }
}
