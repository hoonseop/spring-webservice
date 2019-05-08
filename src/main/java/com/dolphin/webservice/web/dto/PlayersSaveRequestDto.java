package com.dolphin.webservice.web.dto;

import com.dolphin.webservice.domain.Players;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayersSaveRequestDto {
    private String playerId;
    private String teamName;
    private String playerName;
    private String position;
    private int number;
    private int salary;
    private boolean isEnroll;

    public Players toEntity(){
        return Players.builder()
                .teamName(teamName)
                .playerName(playerName)
                .position(position)
                .number(number)
                .salary(salary)
                .isEnroll(isEnroll)
                .build();
    }

    @Builder
    public PlayersSaveRequestDto(String teamName, String playerName, String position, int number, int salary, boolean isEnroll) {
    	this.playerId = teamName + number;
        this.teamName = teamName;
        this.playerName = playerName;
        this.position = position;
        this.number = number;
        this.salary = salary;
        this.isEnroll = isEnroll;
    }

}
