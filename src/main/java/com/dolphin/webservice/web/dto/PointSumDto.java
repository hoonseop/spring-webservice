package com.dolphin.webservice.web.dto;

import com.dolphin.webservice.domain.PointSum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 
SELECT s FROM com.dolphin.webservice.domain.PointSum sORDER by s.summary DESC
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PointSumDto {
    private String playerId;
    private String teamName;
    private String number;
    private String playerName;
    private double summary;

    public PointSumDto(PointSum entity) {
        playerId = entity.getPlayerId();
        playerName = entity.getPlayerName();
        summary = entity.getSummary();
        
		number = playerId.replaceAll("[^0-9]", "");
		teamName = playerId.substring(0, playerId.indexOf(number));
    }

    public PointSumDto toEntity(){
        return PointSumDto.builder()
                .playerId(playerId)
                .playerName(playerName)
                .summary(summary)
                .build();
    }

    @Builder
    public PointSumDto(String playerId, String playerName, double summary) {
    	this.playerId = playerId;        
		number = playerId.replaceAll("[^0-9]", "");
		teamName = playerId.substring(0, playerId.indexOf(number));
        this.playerName = playerName;
        this.summary = summary;
    }

}
