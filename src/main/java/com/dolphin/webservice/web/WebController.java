package com.dolphin.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dolphin.webservice.service.PlayerService;
import com.dolphin.webservice.service.PointService;
import com.dolphin.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

    private PlayerService playerService;
    private PointService pointService;
    private PostsService postsService;

    @GetMapping("/player")
    public String player(Model model) {
        model.addAttribute("player", playerService.findAllDesc());
        return "player";
    }

    @GetMapping("/posts")
    public String post(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts";
    }

    @GetMapping("/point")
    public String point(Model model) {
        model.addAttribute("point", pointService.findAllDesc());
        return "point";
    }
}