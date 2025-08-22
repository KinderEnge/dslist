package com.kinderenge.dslist.controllers;

import com.kinderenge.dslist.dto.GameDTO;
import com.kinderenge.dslist.dto.GameMinDTO;
import com.kinderenge.dslist.entities.Game;
import com.kinderenge.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO>findAll(){
        List<GameMinDTO>result=gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(Long id){
        GameDTO result=gameService.findById(id);
        return result;
    }
}
