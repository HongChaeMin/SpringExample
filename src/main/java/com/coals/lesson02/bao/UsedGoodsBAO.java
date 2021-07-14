package com.coals.lesson02.bao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coals.lesson02.model.UsedGoods;

@Repository
public interface UsedGoodsBAO {

	public List<UsedGoods> selectUesdGoodsList();
	
}
