package com.coals.lesson01;

// 기본 패키지 com.marobiana.ex 에서 lesson01로 변경되어 404 발생
// 설정 클래스에서 @ComponentScan으로 기본 패키지를 다시 잡아준다.

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")  // 메소드에 붙은 mapping보다 먼저 적용
@Controller
public class Ex01Controller {
	
	// String 출력하기
	// 요청 URL: http://localhost:8080/lesson01/ex01/1
	@ResponseBody 			   // 리턴되는 값을 HTML Response로 보낸다.
	@RequestMapping("/1")   // 주소 매핑
	public String printString() {
		String text = "예제1번<br>문자열을 response body로 보내는 예제";
		return text;
	}
	
	// Map 출력하기 -> JSON 출력하기
	// 요청 URL: http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 10);
		map.put("orange", 125);
		map.put("grape", 67);
		
		// map을 리턴하면 json으로 나타난다. web starter에 jackson 이라는 라이브러리가 포함되어있기 때문
		return map;
	}
}