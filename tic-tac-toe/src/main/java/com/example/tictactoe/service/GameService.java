package com.example.tictactoe.service;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.Player;
import com.example.tictactoe.model.STATE;
import com.example.tictactoe.response.GameResponse;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class GameService {

    Map<String, Game> gameMap = new HashMap<>();

    // create game
    public GameResponse createGame(String name) {
        Game game = new Game();
        Player player1 = new Player(name, 'x');
        game.setPlayer1(player1);
        game.setTurn(player1);
        gameMap.put(game.getGameId(), game);
        GameResponse response = new GameResponse(game);
        return response;
    }

    // join game
    // containsKey() method is used to check whether a particular key is being mapped into the HashMap or not.
    public GameResponse joinGame(String name, String gameId) {

        if(gameMap.containsKey(gameId)) {
            Game game = gameMap.get(gameId);

            if (game.getState() == STATE.PLAY) {
                return null;
            }
            Player player2 = new Player(name, 'o');
            game.setPlayer2(player2);
            game.setState(STATE.PLAY);

            return new GameResponse(game);
        }
        return null;

    }

    public List<GameResponse> getAllGame() {
        List<GameResponse> gameResponseList = new ArrayList<>();
        for (Game game : gameMap.values()) {
            GameResponse gameResponse = new GameResponse(game);
            gameResponseList.add(gameResponse);
        }
        return gameResponseList;
    }

    public Game getGame(String gameId) {
        if (gameMap.containsKey(gameId)) {
            Game game = gameMap.get(gameId);
            return game;
        }
        return null;
    }



}
