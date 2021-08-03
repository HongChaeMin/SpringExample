package com.coals.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coals.lesson04.dao.NewUserDAO;
import com.coals.lesson04.model.NewUser;

@Service
public class NewUserBO {

	@Autowired
	private NewUserDAO newUserDAO;
	
	public void insertNewUser(String name, String yyyymmdd, String email, String introduce) {
		newUserDAO.insertNewUser(name, yyyymmdd, email, introduce);
	}
	
	public NewUser getLastUser() {
		return newUserDAO.selectLastUser();
	}
	
	public boolean existNewUserByName(String name) {
		return newUserDAO.existNewUSerByName(name);
	}
	
}
