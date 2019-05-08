package com.dolphin.webservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Players extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String playerId;

    @Column(length = 16, nullable = false)
    private String teamName;

    @Column(length = 16, nullable = false)
    private String playerName;

    @Column(length = 1, nullable = false)
    private String position;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private int salary;

    @Column(nullable = false)
    private boolean isEnroll;

    @Builder
    public Players(String teamName, String playerName, String position, int number, int salary, boolean isEnroll) {
        this.teamName = teamName;
        this.playerName = playerName;
        this.position = position;
        this.number = number;
        this.salary = salary;
        this.isEnroll = isEnroll;
        playerId = teamName + number;
    }

}
