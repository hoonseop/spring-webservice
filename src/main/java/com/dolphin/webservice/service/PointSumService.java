package com.dolphin.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolphin.webservice.domain.repository.PointSumRepository;
import com.dolphin.webservice.web.dto.PointSumDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PointSumService {
    private PointSumRepository pointSumRepository;

    @Transactional(readOnly = true)
    public List<PointSumDto> findPointSum() {
        return pointSumRepository.findPointSum()
                .map(PointSumDto::new)
                .collect(Collectors.toList());
    }

}
