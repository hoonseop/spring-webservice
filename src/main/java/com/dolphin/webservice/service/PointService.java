package com.dolphin.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolphin.webservice.domain.repository.PointRepository;
import com.dolphin.webservice.web.dto.PointMainResponseDto;
import com.dolphin.webservice.web.dto.PointSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PointService {
    private PointRepository playerRepository;

    @Transactional
    public Long save(PointSaveRequestDto dto){
        return playerRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PointMainResponseDto> findAllDesc() {
        return playerRepository.findAllDesc()
                .map(PointMainResponseDto::new)
                .collect(Collectors.toList());
    }

}
