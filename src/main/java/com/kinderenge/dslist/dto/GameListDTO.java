package com.kinderenge.dslist.dto;

import com.kinderenge.dslist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public GameListDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
