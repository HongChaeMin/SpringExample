package com.coals.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Controller {

	@RequestMapping("/lesson05/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@RequestMapping("/lesson05/ex02")
	public String ex02(Model model) {
		
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("melon");
		fruits.add("peach");
		fruits.add("prape");
		fruits.add("mango");
		
		model.addAttribute("fruits", fruits);
		
		// List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "홍채민");
		map1.put("age", 19);
		map1.put("hobby", "노래하기");
		users.add(map1);
		
		map1 = new HashMap<>();
		map1.put("name", "남상호");
		map1.put("age", 25);
		map1.put("hobby", "스크래칭");
		users.add(map1);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
		
}
