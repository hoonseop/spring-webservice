package com.dolphin.webservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dolphin.webservice.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query("SELECT count(o) " +
            "FROM Owner o where o.email = :email ")
    Long checkEmail(@Param("email") String email);

}
