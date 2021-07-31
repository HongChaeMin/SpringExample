package com.coals.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coals.lesson04.bo.NewUserBO;
import com.coals.lesson04.model.NewUser;

@RequestMapping("/lesson06/ex01")
@Controller
public class lesson06Controller {

	@Autowired
	private NewUserBO newUserBO;
	
	@RequestMapping("/add_new_user_view")
	public String ex01() {
		return "lesson06/addNewUser";
	}
	
	@PostMapping("/add_new_user")
	@ResponseBody
	public String addNewUser(
			@RequestParam("name") String name
			, @RequestParam("yyyymmdd") String yyyymmdd
			, @RequestParam(value = "email", required = false) String email
			, @RequestParam(value = "introduce" ,  required = false) String introduce
			) {
		// alt + shift + r : 이름바꾸기
		// ctrl + r + h : 누가 불렀는지 보여줌 
		//newUserBO.insertNewUser(name, yyyymmdd, email, introduce);
		
		// {"result":"success" , resultCode:200, date:ull}
		// {"result":"fail", resultCode:500, errorMessage:"...."}
		return "success!";
	}
	
	@RequestMapping("/get_new_user")
	public String getNewUser(Model model) {
		NewUser newUser = newUserBO.getLastUser();
		model.addAttribute("newUSer", newUser);
		return "lesson06/getNewUser";
	}
	
}
