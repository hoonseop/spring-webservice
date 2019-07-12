package com.dolphin.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolphin.webservice.domain.repository.PointRepository;
import com.dolphin.webservice.web.dto.PointDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PointService {
    private PointRepository pointRepository;

    @Transactional
    public Long save(PointDto dto){
        return pointRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PointDto> findPointAll() {
        return pointRepository.findPointAll()
                .map(PointDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PointDto> findPointByPlayDate(String playDate) {
        return pointRepository.findPointByPlayDate(playDate)
                .map(PointDto::new)
                .collect(Collectors.toList());
    }

}
