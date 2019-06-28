package com.dolphin.webservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Entity
public class Lineup extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String ownerId;

    @Column(length = 16, nullable = false)
    private String playerId;

//    @Column(length = 16, nullable = false)
//    private String date;

    @Builder
    public Lineup(String ownerId, String playerId) {
//    public Lineup(String ownerId, String playerId, String date) {
        this.ownerId = ownerId;
        this.playerId = playerId;
//        this.date = date;
    }

}
