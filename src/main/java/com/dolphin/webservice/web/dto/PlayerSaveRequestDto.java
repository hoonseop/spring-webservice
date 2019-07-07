package com.dolphin.webservice.web.dto;

import com.dolphin.webservice.domain.Player;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PlayerSaveRequestDto {
    private String playerId;
    private String teamName;
    private String playerName;
    private String position;
    private int number;
    private int salary;

    public Player toEntity(){
        return Player.builder()
                .teamName(teamName)
                .playerName(playerName)
                .position(position)
                .number(number)
                .salary(salary)
                .build();
    }

    @Builder
    public PlayerSaveRequestDto(String teamName, String playerName, String position, int number, int salary) {
    	this.playerId = teamName + number;
        this.teamName = teamName;
        this.playerName = playerName;
        this.position = position;
        this.number = number;
        this.salary = salary;
    }

}
