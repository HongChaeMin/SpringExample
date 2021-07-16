package com.coals.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coals.lesson03.bo.ReviewBO;
import com.coals.lesson03.model.Review;

@RestController // @Controller + @ResponseBody
public class ReviewRestController {

	@Autowired
	private ReviewBO reviewBO;

	// 요청 URL : http://localhost/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review printReview(
			// 필수 파라미터 @RequestParam(value = "id") int id
			// 필수 파라미터 @RequestParam(value="id", required=true) int id
			// 비필수 파라미터 @RequestParam(value = "id", required = false) Integer id
			// 값이 없을 수도 있기 때문에 null 저장을 위해 Integer로 저장
			@RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터, 기본값 설정 (1)
	) {
		System.out.println("### id : " + id);
		return reviewBO.getReview(id);
	}

}
