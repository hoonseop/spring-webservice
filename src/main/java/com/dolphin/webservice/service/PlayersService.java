package com.dolphin.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolphin.webservice.domain.repository.PlayersRepository;
import com.dolphin.webservice.web.dto.PlayersMainResponseDto;
import com.dolphin.webservice.web.dto.PlayersSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PlayersService {
    private PlayersRepository playersRepository;

    @Transactional
    public Long save(PlayersSaveRequestDto dto){
        return playersRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PlayersMainResponseDto> findAllDesc() {
        return playersRepository.findAllDesc()
                .map(PlayersMainResponseDto::new)
                .collect(Collectors.toList());
    }

}
