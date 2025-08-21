package com.kinderenge.dslist.repositories;

import com.kinderenge.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
