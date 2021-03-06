package com.coals.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coals.lesson03.dao.ReviewDAO;
import com.coals.lesson03.model.Review;

@Service
public class ReviewBO {

	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {
		return reviewDAO.selectReview(id);
	}
	
	public int insertReview (Review review) {
		return reviewDAO.insertReview(review);
	}
	
	public int insertReviewAsField (String storeName, String menu, String userName, double point, String review) {
		return reviewDAO.insertReviewAsField(storeName, menu, userName, point, review);
	}
	
	public int updateReview(int id, String review) {
		return reviewDAO.updateReview(id, review);
	}
	
	public int deleteReview(int id) {
		return reviewDAO.deleteReview(id);
	}
}
