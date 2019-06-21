package com.dolphin.webservice.web.dto;

import com.dolphin.webservice.domain.Player;

import lombok.Getter;

@Getter
public class PlayerMainResponseDto {
//    private Long id;
    private String playerId;
    private String teamName;
    private String playerName;
    private String position;
    private int number;
    private int salary;
//    private boolean isEnroll;

    public PlayerMainResponseDto(Player entity) {
//        id = entity.getId();
        playerId = entity.getPlayerId();
        teamName = entity.getTeamName();
        playerName = entity.getPlayerName();
        position = entity.getPosition();
        number = entity.getNumber();
        salary = entity.getSalary();
//        isEnroll = entity.isEnroll();
    }

}