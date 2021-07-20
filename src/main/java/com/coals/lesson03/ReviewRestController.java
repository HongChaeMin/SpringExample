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

	// ��û URL : http://localhost/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review printReview(
			//@RequestParam(value="id") int id // 필수 파라미터
			//@RequestParam(value="id", required=true) int id // 필수 파라미터
			//@RequestParam(value="id", required=false) Integer id // 비필수 파라미터
			@RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터, 디폴트값 1
	) {
		System.out.println("### id : " + id);
		return reviewBO.getReview(id);
	}
	
	// ��û URL : http://localhost/lesson03/ex02
	@RequestMapping("/lesson03/ex02")
	public String ex02() {
		Review review = new Review();
		review.setStoreName("ä�� ����");
		review.setMenu("���ȥ�似Ʈ");
		review.setUserName("��������¢�°�");
		review.setPoint(5.0);
		review.setReview("�۸۸Ӿ�����۸۸۸۸Ӿ�������!!!");
		
		int row = reviewBO.insertReview(review); // insert 된 row 수를 리턴 받는다.
		
		return "success row count : " + row; // @ResponseBody�� ���� String �� ��ü�� responseBody�� ����
	}

	@RequestMapping("lesson03/ex02/2")
	public String ex02_2() {
		int row = reviewBO.insertReviewAsField("���̳�����", "�޺���̼�R", "ä��ȫ", 3.0, "���߳� ���߾�");
		
		return "succes row count : " + row;
	}
	
	// 요청 URL : http://localhost/lesson03/ex03?id=5&review=삽겹살은 역시 맛있어~~
	@RequestMapping("/lesson03/ex03") 
	public String ex03(
			@RequestParam("id") int id
			, @RequestParam("review") String review
			) {
		
		return "변경 완료 : " + reviewBO.updateReview(id, review);
	}
	
	// 요청 URL : http://localhost/lesson03/ex04?id=18
	@RequestMapping("/lesson03/ex04")
	public String ex04(@RequestParam("id") int id) {
		return "삭제 성공 : " + reviewBO.deleteReview(id);
	}
}
