package com.kinderenge.dslist.services;

import com.kinderenge.dslist.dto.GameListDTO;
import com.kinderenge.dslist.dto.GameMinDTO;
import com.kinderenge.dslist.entities.GameList;
import com.kinderenge.dslist.projections.GameMinProjection;
import com.kinderenge.dslist.repositories.GameListRepository;
import com.kinderenge.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList>result = gameListRepository.findAll();
        return result.stream().map(x->new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinantionIndex){
        List<GameMinProjection>list = gameRepository.searchByList(listId);

        GameMinProjection obj =  list.remove(sourceIndex);
        list.add(destinantionIndex, obj);

        int min = sourceIndex<destinantionIndex ? sourceIndex : destinantionIndex;
        int max = sourceIndex<destinantionIndex ? destinantionIndex : sourceIndex;

        for (int i = min; i<=max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
