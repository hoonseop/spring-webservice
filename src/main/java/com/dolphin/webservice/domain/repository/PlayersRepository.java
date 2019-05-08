package com.dolphin.webservice.domain.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dolphin.webservice.domain.Players;

public interface PlayersRepository extends JpaRepository<Players, Long> {

    @Query("SELECT p " +
            "FROM Players p " +
            "ORDER BY p.id DESC")
    Stream<Players> findAllDesc();

}
