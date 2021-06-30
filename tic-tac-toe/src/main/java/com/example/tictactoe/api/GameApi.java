package com.example.tictactoe.api;


import com.example.tictactoe.model.Game;
import com.example.tictactoe.response.GameResponse;
import com.example.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/game")
public class GameApi {


    @Autowired
    GameService gameService;


    @PostMapping("/{name}")
    public GameResponse createGame(@PathVariable String name) {

      return gameService.createGame(name);
    }

    @GetMapping
    public List<GameResponse> getAllGame() {
        return gameService.getAllGame();
    }

    @GetMapping ("/{gameId}")
    public Game getGame (@PathVariable String gameId) {
       return gameService.getGame(gameId);
    }

    @PutMapping("/{name}/{gameId}")
    public GameResponse joinGame(@PathVariable String name, @PathVariable String gameId){
        return gameService.joinGame(name, gameId);
    }

}
