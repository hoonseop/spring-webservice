package com.dolphin.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolphin.webservice.domain.repository.PlayerRepository;
import com.dolphin.webservice.web.dto.PlayerDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    @Transactional
    public Long savePlayer(PlayerDto dto){
        return playerRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PlayerDto> findPlayerAll() {
        return playerRepository.findPlayerAll()
                .map(PlayerDto::new)
                .collect(Collectors.toList());
    }

}
