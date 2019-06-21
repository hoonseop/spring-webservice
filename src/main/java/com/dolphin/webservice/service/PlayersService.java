package com.dolphin.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolphin.webservice.domain.repository.PlayersRepository;
import com.dolphin.webservice.web.dto.PlayerMainResponseDto;
import com.dolphin.webservice.web.dto.PlayerSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PlayersService {
    private PlayersRepository playersRepository;

    @Transactional
    public Long save(PlayerSaveRequestDto dto){
        return playersRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PlayerMainResponseDto> findAllDesc() {
        return playersRepository.findAllDesc()
                .map(PlayerMainResponseDto::new)
                .collect(Collectors.toList());
    }

}
