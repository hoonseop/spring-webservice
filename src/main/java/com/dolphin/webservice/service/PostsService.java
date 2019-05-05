package com.dolphin.webservice.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dolphin.webservice.domain.posts.PostsRepository;
import com.dolphin.webservice.web.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}