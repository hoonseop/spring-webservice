package com.dolphin.webservice.web.dto;

import com.dolphin.webservice.domain.Point;

import lombok.Getter;

@Getter
public class PointMainResponseDto {
    private String playerId;
    private String playerName;
    private String playDate;
    private double point;

    public PointMainResponseDto(Point entity) {
        playerId = entity.getPlayerId();
        playerName = entity.getPlayerName();
        playDate = entity.getPlayDate();
        point = entity.getPoint();
    }

}
