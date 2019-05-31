package com.dolphin.webservice.web;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.dolphin.webservice.domain.repository.PostsRepository;
import com.dolphin.webservice.service.PlayersService;
import com.dolphin.webservice.service.PostsService;
import com.dolphin.webservice.web.dto.PlayersSaveRequestDto;
import com.dolphin.webservice.web.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
//    private PostsRepository postsRepository;
    private PostsService postsService;
    private PlayersService playersService;
    private Environment environment;

	@GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

	@GetMapping("/profile")
    public String getProfile() {
		return Arrays.stream(environment.getActiveProfiles())
                .findFirst()
                .orElse("");
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @PostMapping("/players")
    public Long savePlayers(@RequestBody PlayersSaveRequestDto dto){
        return playersService.save(dto);
    }
//    public void savePosts(@RequestBody PostsSaveRequestDto dto){
//        postsRepository.save(dto.toEntity());
//    }
}
