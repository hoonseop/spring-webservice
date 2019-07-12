package com.dolphin.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dolphin.webservice.domain.Player;
import com.dolphin.webservice.domain.repository.PlayerRepository;
import com.dolphin.webservice.web.dto.PlayerDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerServiceTest {

    @Autowired
    private PlayerService playersService;

    @Autowired
    private PlayerRepository playersRepository;

    @After
    public void cleanup () {
        playersRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_players테이블에_저장된다 () {
        //given
        PlayerDto dto = PlayerDto.builder()
                .teamName("wyverns")
                .playerName("최정")
                .number(14)
                .position("I")
                .salary(1200)
                .build();

        //when
        playersService.savePlayer(dto);

        //then
        for(Player players: playersRepository.findAll()) {
        	dto = PlayerDto.builder()
                    .teamName(players.getTeamName())
                    .playerName(players.getPlayerName())
                    .number(players.getNumber())
                    .position(players.getPosition())
                    .salary(players.getSalary())
                    .build();
            System.out.println(dto.toString());
        }

        Player players = playersRepository.findAll().get(0);
        assertThat(players.getTeamName()).isEqualTo(dto.getTeamName());
        assertThat(players.getPlayerName()).isEqualTo(dto.getPlayerName());
        assertThat(players.getNumber()).isEqualTo(dto.getNumber());
        assertThat(players.getPosition()).isEqualTo(dto.getPosition());
        assertThat(players.getSalary()).isEqualTo(dto.getSalary());
        System.out.println("\n" + dto.toString() + "\n");
    }
}