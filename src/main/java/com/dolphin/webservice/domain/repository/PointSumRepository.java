package com.dolphin.webservice.domain.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dolphin.webservice.domain.PointSum;

public interface PointSumRepository extends JpaRepository<PointSum, Long> {

    @Query("SELECT s " + 
    		"FROM PointSum s " + 
    		"ORDER by s.summary DESC")
    Stream<PointSum> findPointSum();

}
