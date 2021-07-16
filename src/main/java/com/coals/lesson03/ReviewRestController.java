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
			// �ʼ� �Ķ���� @RequestParam(value = "id") int id
			// �ʼ� �Ķ���� @RequestParam(value="id", required=true) int id
			// ���ʼ� �Ķ���� @RequestParam(value = "id", required = false) Integer id
			// ���� ���� ���� �ֱ� ������ null ������ ���� Integer�� ����
			@RequestParam(value="id", defaultValue="1") int id // ���ʼ� �Ķ����, �⺻�� ���� (1)
	) {
		System.out.println("### id : " + id);
		return reviewBO.getReview(id);
	}

}