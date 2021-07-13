package com.coals.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody : ?°?´?„°ë¥? ?‚´ë¦? ?•Œ ì£¼ë¡œ ?‚¬?š©?•œ?‹¤
public class Ex01RestController {

	// ?š”ì²? url : http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestControllerë¥? ?‚¬?š©?•´?„œ String?„ ë¦¬í„´?•´ë³¸ë‹¤";
	}
	
	@RequestMapping("/4")
	public Map<String, String> printMap(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		map.put("ddd", "444");
		
		return map; // json
	}

	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data(); // ?¼ë°? ?ë°? ë¹?
		data.setId(1);
		data.setName("?™ì±„ë??");
		
		System.out.println(data); // console
		return data; // ?¼ë°? ë¹? ê°ì²´?„ json?œ¼ë¡? ?‚´? ¤ê°„ë‹¤ (jacksom ?¼?´ë¸ŒëŸ¬ë¦? ?•Œë¬¸ì—)
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data = new Data(); // ?¼ë°? java been
		data.setId(2);
		data.setName("ë¯¼ì±„?™");
		
		// return new ResponseEntity<>(data, HttpStatus.OK); // 200 ok
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
