package com.dolphin.webservice.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import org.springframework.ui.Model;

import com.dolphin.webservice.web.dto.PointDto;

public class ControllerUtil {
	private static ControllerUtil controllerUtil = null;
	
//	public static String getDate() {
//		if (controllerUtil == null)
//			controllerUtil = new ControllerUtil();
//		return controllerUtil.getDateSting();
//	}
	
	public static void printModel(Model model) {
		init();
		controllerUtil.printModelValue(model);
	}

	private void printModelValue(Model model) {
		Map<?, ?> result = model.asMap();
    	for(Object key: result.keySet()) {
    		Object value = result.get(key);
    		if(value instanceof ArrayList) {
        		Iterator<?> list = ((ArrayList<?>) result.get(key)).iterator();
        		while(list.hasNext()) {
        			Object dto = list.next();
        			if(dto instanceof PointDto)
        				printPoint((PointDto)dto);
        		}
    		} else {
        		System.out.println(value.getClass());
    		}
    	}
	}

	private void printPoint(PointDto pointDto) {
		System.out.println(pointDto.getPlayerName() + ":" + pointDto.getPlayDate() + ":" + pointDto.getPoint());
	}

	private static void init() {
		if (controllerUtil == null)
			controllerUtil = new ControllerUtil();
	}

//	private String getDateSting() {
//		Calendar cal = Calendar.getInstance();
//		StringBuffer buf = new StringBuffer("" + cal.get(Calendar.YEAR));
//		
//		int month = cal.get(Calendar.MONTH) + 1;
//		if(month > 9) {
//			buf.append(month);
//		} else {
//			buf.append("0" + month);
//		}
//
//		int day = cal.get(Calendar.DAY_OF_MONTH);
//		if(day < 10) {
//			buf.append("0" + day);
//		} else {
//			buf.append(day);
//		}
//		return buf.toString();
//	}

}
