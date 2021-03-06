package com.dolphin.webservice.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dolphin.webservice.service.PlayerService;
import com.dolphin.webservice.service.PointService;
import com.dolphin.webservice.service.PostsService;
import com.dolphin.webservice.web.dto.PlayerDto;
import com.dolphin.webservice.web.dto.PointDto;

import lombok.AllArgsConstructor;

//@Controller
//@AllArgsConstructor
public class WebController {
//	static private String today = null;
//
//	private PlayerService playerService;
//	private PointService pointService;
//	private PostsService postsService;
//
//	@GetMapping("/findPlayerAll")
//	public String findPlayerAll(Model model) {
//		model.addAttribute("player", playerService.findPlayerAll());
//		return "player";
//	}
//
//	@GetMapping("/findPointAll")
//	public String findPointAll(Model model) {
//		model.addAttribute("point", pointService.findPointByPlayDate(getDate()));
//    	printPoint(model);
//		return "point";
//	}
//
//	@PostMapping("/findPointByPlayDate")
//	public String findPointByPlayDate(@RequestBody Map<String, String> params, Model model) {
//		today = params.get("playDate");
//		model.addAttribute("point", pointService.findPointByPlayDate(getDate()));
//    	printPoint(model);
//		return "point";
//	}
//
//    @PostMapping("/savePlayer")
//    public @ResponseBody Long savePlayer(@RequestBody PlayerDto dto){
//        return playerService.savePlayer(dto);
//    }
//
//	private void printPoint(Model model) {
//		Map<?, ?> result = model.asMap();
//    	for(Object key: result.keySet()) {
//    		Object value = result.get(key);
//    		if(value instanceof ArrayList) {
//        		Iterator<?> list = ((ArrayList<?>) result.get(key)).iterator();
//        		while(list.hasNext()) {
//        			PointDto dto = (PointDto) list.next();
//            		System.out.println(dto.getPlayerName() + ":" + dto.getPlayDate() + ":" + dto.getPoint());
//        		}
//    		} else {
//        		System.out.println(value.getClass());
//    		}
//    	}
//	}
//
//	private String getDate() {
//		if(today == null) {
//			Calendar cal = Calendar.getInstance();
//			StringBuffer buf = new StringBuffer("" + cal.get(Calendar.YEAR));
//			
//			int month = cal.get(Calendar.MONTH) + 1;
//			if(month > 9) {
//				buf.append(month);
//			} else {
//				buf.append("0" + month);
//			}
//
//			int day = cal.get(Calendar.DAY_OF_MONTH);
//			if(day < 10) {
//				buf.append("0" + day);
//			} else {
//				buf.append(day);
//			}
//			today = buf.toString();
//		}
//		return today;
//	}
//
//	@GetMapping("/playerAll")
//	public String playerAll(Model model) {
//		model.addAttribute("playerAll", playerService.findPlayerAll());
//		return "playerAll";
//	}
//
//	@GetMapping("/posts")
//	public String post(Model model) {
//		model.addAttribute("posts", postsService.findAllDesc());
//		return "posts";
//	}
}