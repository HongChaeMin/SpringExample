package com.coals.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.coals.lesson04.model.NewStudent;

@Repository
public interface NewStudentDAO {

	public void insertNewStudent(NewStudent newStudent);

	public NewStudent selectNewStudent(int id);

}
