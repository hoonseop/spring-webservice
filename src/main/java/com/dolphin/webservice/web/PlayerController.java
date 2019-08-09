package com.dolphin.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dolphin.webservice.service.PlayerService;
import com.dolphin.webservice.service.PointService;
import com.dolphin.webservice.web.dto.PlayerDto;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PlayerController {
	private PlayerService playerService;

	@GetMapping("/findPlayerAll")
	public String findPlayerAll(Model model) {
		model.addAttribute("player", playerService.findPlayerAll());
		return "player";
	}

    @PostMapping("/savePlayer")
    public @ResponseBody Long savePlayer(@RequestBody PlayerDto dto){
        return playerService.savePlayer(dto);
    }

}
