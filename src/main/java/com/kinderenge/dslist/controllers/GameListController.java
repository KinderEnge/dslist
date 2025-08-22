package com.kinderenge.dslist.controllers;

import com.kinderenge.dslist.dto.GameListDTO;
import com.kinderenge.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO>findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
