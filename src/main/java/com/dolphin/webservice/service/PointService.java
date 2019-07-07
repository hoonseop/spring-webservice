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
    private PointRepository pointRepository;

    @Transactional
    public Long save(PointSaveRequestDto dto){
        return pointRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PointMainResponseDto> findAllDesc() {
        return pointRepository.findAllDesc()
                .map(PointMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PointMainResponseDto> findByDate(String playDate) {
        return pointRepository.findByplaydate(playDate)
                .map(PointMainResponseDto::new)
                .collect(Collectors.toList());
    }

}
