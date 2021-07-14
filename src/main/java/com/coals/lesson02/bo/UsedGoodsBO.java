package com.coals.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coals.lesson02.bao.UsedGoodsBAO;
import com.coals.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO {

	@Autowired
	private UsedGoodsBAO usedGoodsDAO;
	
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsDAO.selectUesdGoodsList();
	}
	
}
