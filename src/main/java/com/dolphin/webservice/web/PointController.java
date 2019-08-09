package com.dolphin.webservice.web;

import java.util.Calendar;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dolphin.webservice.service.PointService;
import com.dolphin.webservice.util.ControllerUtil;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PointController {
	private static String playDate = null;
	private PointService pointService;

	@GetMapping("/findPointToday")
	public String findPointToday(Model model) {
		model.addAttribute("point", pointService.findPointByPlayDate(getDate()));
		return "point";
	}

	@PostMapping("/findPointByPlayDate")
	public String findPointByPlayDate(@RequestBody Map<String, String> params, Model model) {
		playDate = params.get("playDate");
		model.addAttribute("point", pointService.findPointByPlayDate(playDate));
		ControllerUtil.printModel(model);
		
		return "point";
	}

	private String getDate() {
		if(playDate == null) {
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
			playDate = buf.toString();
		}
		return playDate;
	}

}
