package com.dolphin.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dolphin.webservice.domain.Players;
import com.dolphin.webservice.domain.repository.PlayersRepository;
import com.dolphin.webservice.web.dto.PlayersSaveRequestDto;

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
        PlayersSaveRequestDto dto = PlayersSaveRequestDto.builder()
                .teamName("wyverns")
                .playerName("테스트")
                .number(0)
                .position("P")
                .salary(0)
                .isEnroll(true)
                .build();

        //when
        playersService.save(dto);

        //then
        Players players = playersRepository.findAll().get(0);
        assertThat(players.getTeamName()).isEqualTo(dto.getTeamName());
        assertThat(players.getPlayerName()).isEqualTo(dto.getPlayerName());
        assertThat(players.getNumber()).isEqualTo(dto.getNumber());
        assertThat(players.getPosition()).isEqualTo(dto.getPosition());
        assertThat(players.getSalary()).isEqualTo(dto.getSalary());
        assertThat(players.isEnroll()).isEqualTo(dto.isEnroll());
    }
}