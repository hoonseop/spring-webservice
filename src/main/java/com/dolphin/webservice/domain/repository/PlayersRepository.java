package com.dolphin.webservice.domain.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dolphin.webservice.domain.Player;

public interface PlayersRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p " +
            "FROM Player p " +
            "ORDER BY p.id DESC")
    Stream<Player> findAllDesc();

}
