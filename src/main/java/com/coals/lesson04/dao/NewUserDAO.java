package com.coals.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.coals.lesson04.model.NewUser;

@Repository
public interface NewUserDAO {

	public void insertNewUser(
			@Param ("name") String name
			, @Param ("yyyymmdd")  String yyyymmdd
			, @Param ("email") String email
			, @Param ("introduce") String introduce
			);

	public NewUser selectLastUser();

	public boolean existNewUSerByName(String name);
	
}
