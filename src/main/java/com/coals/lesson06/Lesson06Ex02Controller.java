package com.coals.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coals.lesson04.bo.NewUserBO;

@Controller
@RequestMapping("/lesson06/ex02")
public class Lesson06Ex02Controller {

	@Autowired
	private NewUserBO newUserBO;
	
	@RequestMapping("/add_name")
	public String addName() {
		return "lesson06/addName";
	}
	
	@RequestMapping("/is_duplication")
	@ResponseBody // AJAX의 요청이므로 ResponseBody 추가
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name
			) {
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", newUserBO.existNewUserByName(name));
		
		return result;
	}
	
}
