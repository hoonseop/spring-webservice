package com.dolphin.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dolphin.webservice.service.PlayersService;
import com.dolphin.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

    private PlayersService playersService;
    private PostsService postsService;

    @GetMapping("/players")
    public String player(Model model) {
        model.addAttribute("players", playersService.findAllDesc());
        return "players";
    }

    @GetMapping("/posts")
    public String post(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts";
    }
}