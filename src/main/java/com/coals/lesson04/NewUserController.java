package com.coals.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coals.lesson04.bo.NewUserBO;
import com.coals.lesson04.model.NewUser;

@RequestMapping("/lesson04/ex01")
@Controller
public class NewUserController {

	@Autowired
	private NewUserBO newUserBO;
	
	//http://localhost/lesson04/ex01/1
	@RequestMapping(path = "/1", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // view 경로
	}
	
	@PostMapping("/addUser")
	public String addUser(
			@RequestParam("name") String name
			, @RequestParam("yyyymmdd") String yyyymmdd
			, @RequestParam(value = "email", required = false) String email // 비필수 파라미터
			, @RequestParam(value = "introduce", required = false) String introduce // 비필수
			) {
		// request -> response
		
		// TODO db insert
		newUserBO.insertNewUser(name, yyyymmdd, email, introduce);
		
		// 결과 jsp
		return "lesson04/afterAddUser";
	}
	
	/**
	 * 가장 최근에 추가된 사람 한 명 가져오기
	 * @return
	 */
	// http://localhost/lesson04/ex01/get_last_user
	@GetMapping("/get_last_user")
	public String getLastUserView(Model model) { // view 화면에 데이터를 넘겨주는 객체 (ModelAndView 객체는 요즘 잘 사용하지 않는다)
		NewUser newUser = newUserBO.getLastUser();
		model.addAttribute("result", newUser); // 결과 jsp view에 결과 객체 값을 넘겨준다
		model.addAttribute("subject", "유저 정보");
		return "lesson04/getLastUser";
	}
}
