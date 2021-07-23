package com.coals.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coals.lesson04.bo.NewStudentBO;
import com.coals.lesson04.model.NewStudent;

@RequestMapping("/lesson04/ex02")
@Controller
public class NewStudentController {

	@Autowired
	private NewStudentBO newStudentBO;
	
	@RequestMapping("/1")
	public String ex01() {
		return "lesson04/addNewStudent";
	}
	
	@PostMapping("/add_student")
	public String addStudent(
			Model model
			, @ModelAttribute NewStudent newStudent // name 태그 값과 일치하는 필드에 값이 들어간다
			) {
		
		newStudentBO.insertNewStudent(newStudent);
		
		newStudent = newStudentBO.getNewStudentById(newStudent.getId());
		model.addAttribute("result", newStudent);
		model.addAttribute("subject", "학생 정보");
		
		return "lesson04/afterAddStudent";
	}
	
}
