package com.example.tictactoe.api;

import com.example.tictactoe.model.PlayRequest;
import com.example.tictactoe.response.GameResponse;
import com.example.tictactoe.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/play")
public class PlayApi {
    @Autowired
    PlayService playService;

    @PutMapping()
    public GameResponse play(@RequestBody PlayRequest playRequest){
        return  playService.play(playRequest);
    }




}
