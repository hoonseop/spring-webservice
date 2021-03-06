package com.dolphin.webservice.web.dto;

import com.dolphin.webservice.domain.Point;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PointDto {
    private String playerId;
    private String teamName;
    private String number;
    private String playerName;
    private String playDate;
    private double point;

    public PointDto(Point entity) {
        playerId = entity.getPlayerId();
        playerName = entity.getPlayerName();
        playDate = entity.getPlayDate();
        point = entity.getPoint();
        
		number = playerId.replaceAll("[^0-9]", "");
		teamName = playerId.substring(0, playerId.indexOf(number));
    }

    public Point toEntity(){
        return Point.builder()
                .playerId(playerId)
                .playerName(playerName)
                .playDate(playDate)
                .point(point)
                .build();
    }

    @Builder
    public PointDto(String playerId, String playerName, String playDate, double point) {
    	this.playerId = playerId;
        this.playerName = playerName;
        this.playDate = playDate;
        this.point = point;
        
		number = playerId.replaceAll("[^0-9]", "");
		teamName = playerId.substring(0, playerId.indexOf(number));
    }

}
