package com.dolphin.webservice.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.dolphin.webservice.domain.Point;
import com.dolphin.webservice.service.PlayerService;
import com.dolphin.webservice.service.PointService;
import com.dolphin.webservice.service.PostsService;
import com.dolphin.webservice.web.dto.PointMainResponseDto;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	static private String today = "20190704";

    private PlayerService playerService;
    private PointService pointService;
    private PostsService postsService;

    @GetMapping("/player")
    public String player(Model model) {
        model.addAttribute("player", playerService.findAllDesc());
        return "player";
    }

    @GetMapping("/playerAll")
    public String playerAll(Model model) {
        model.addAttribute("playerAll", playerService.findAllDesc());
        return "playerAll";
    }

    @GetMapping("/posts")
    public String post(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts";
    }

    @GetMapping("/point")
    public String point(Model model) {
        model.addAttribute("point", pointService.findByDate(getDate()));
//    	Map params = model.asMap();
//    	for(Object key: params.keySet()) {
//    		Iterator list = ((ArrayList) params.get(key)).iterator();
//    		while(list.hasNext()) {
//    			PointMainResponseDto dto = (PointMainResponseDto) list.next();
//        		System.out.println(dto.getPlayerName() + ":" + dto.getPlayDate() + ":" + dto.getPoint());
//    		}
//    	}
        return "point";
    }
	
	private String getDate() {
		if(today == null) {
			Calendar cal = Calendar.getInstance();
			StringBuffer buf = new StringBuffer("" + cal.get(Calendar.YEAR));
			
			int month = cal.get(Calendar.MONTH) + 1;
			if(month > 9) {
				buf.append(month);
			} else {
				buf.append("0" + month);
			}

			int day = cal.get(Calendar.DAY_OF_MONTH);
			if(day < 10) {
				buf.append("0" + day);
			} else {
				buf.append(day);
			}
			today = buf.toString();
		}
		return today;
	}

//    @GetMapping("/point")
//    public String point(Model model) {
//        model.addAttribute("point", pointService.findAllDesc());
//        return "point";
//    }
}