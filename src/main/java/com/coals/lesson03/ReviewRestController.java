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
	
	// 요청 URL : http://localhost/lesson03/ex02
	@RequestMapping("/lesson03/ex02")
	public String ex02() {
		Review review = new Review();
		review.setStoreName("채민 삼겹살");
		review.setMenu("삼겹혼밥세트");
		review.setUserName("맛있으면짖는개");
		review.setPoint(5.0);
		review.setReview("멍멍머엄엄어멍멍멍멍머엄엄엄멍!!!");
		
		int row = reviewBO.insertReview(review); // insert 된 row 수를 리턴 받는다
		
		return "success row count : " + row; // @ResponseBody로 인해 String 값 자체가 responseBody에 담긴다
	}

	@RequestMapping("lesson03/ex02/2")
	public String ex02_2() {
		int row = reviewBO.insertReviewAsField("도미노피자", "콤비네이션R", "채민홍", 3.0, "변했네 변했어");
		
		return "succes row count : " + row;
	}
}
