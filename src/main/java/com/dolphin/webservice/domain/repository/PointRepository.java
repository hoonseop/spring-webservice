package com.dolphin.webservice.domain.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dolphin.webservice.domain.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

    @Query("SELECT p " +
            "FROM Point p " +
            "ORDER BY p.playDate DESC, p.point DESC")
    Stream<Point> findAllDesc();

}
