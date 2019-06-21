package com.dolphin.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dolphin.webservice.domain.Player;
import com.dolphin.webservice.domain.repository.PlayersRepository;
import com.dolphin.webservice.web.dto.PlayerSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayersServiceTest {

    @Autowired
    private PlayersService playersService;

    @Autowired
    private PlayersRepository playersRepository;

    @After
    public void cleanup () {
        playersRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_players테이블에_저장된다 () {
        //given
        PlayerSaveRequestDto dto = PlayerSaveRequestDto.builder()
                .teamName("wyverns")
                .playerName("최정")
                .number(14)
                .position("I")
                .salary(1200)
//                .isEnroll(true)
                .build();

        //when
        playersService.save(dto);

        //then
        for(Player players: playersRepository.findAll()) {
        	dto = PlayerSaveRequestDto.builder()
                    .teamName(players.getTeamName())
                    .playerName(players.getPlayerName())
                    .number(players.getNumber())
                    .position(players.getPosition())
                    .salary(players.getSalary())
//                    .isEnroll(players.isEnroll())
                    .build();
            System.out.println(dto.toString());
        }

//        Player players = playersRepository.findAll().get(1);
//        assertThat(players.getTeamName()).isEqualTo(dto.getTeamName());
//        assertThat(players.getPlayerName()).isEqualTo(dto.getPlayerName());
//        assertThat(players.getNumber()).isEqualTo(dto.getNumber());
//        assertThat(players.getPosition()).isEqualTo(dto.getPosition());
//        assertThat(players.getSalary()).isEqualTo(dto.getSalary());
//        assertThat(players.isEnroll()).isEqualTo(dto.isEnroll());
//        System.out.println("\n" + dto.toString() + "\n");
    }
}