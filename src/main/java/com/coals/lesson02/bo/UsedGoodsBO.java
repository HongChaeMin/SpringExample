package com.coals.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coals.lesson02.dao.UsedGoodsDAO;
import com.coals.lesson02.model.UsedGoods;

@Service  // 비지니스 로직이 담기는 용도의 스피링빈으로 등
public class UsedGoodsBO {

	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsDAO.selectUesdGoodsList();
	}
	
}
