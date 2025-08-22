package com.kinderenge.dslist.services;

import com.kinderenge.dslist.dto.GameListDTO;
import com.kinderenge.dslist.dto.GameMinDTO;
import com.kinderenge.dslist.entities.GameList;
import com.kinderenge.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList>result = gameListRepository.findAll();
        return result.stream().map(x->new GameListDTO(x)).toList();
    }
}
