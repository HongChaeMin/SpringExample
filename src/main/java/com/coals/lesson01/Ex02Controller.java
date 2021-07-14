package com.coals.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // jsp �� ������ ���� @ResponseBody�� ������ �ʴ´�
public class Ex02Controller {

	// ��û url - http://localhost/lesson01/ex02/1
	@RequestMapping("/lesson01/ex/1")
	public String ex02_1() {
		// ResponseBody�� �ƴ� ���·� String�� �����ϸ�
		// ViewResolver�� ���� ���ϵ� String �̸��� view�� ã�� view ȭ���� �����ȴ�
		
		// /WEB-INF/jsp/     <lesson01/ex02>              .jsp
		return "lesson01/ex02"; // jsp view �̸� (prefix, suffix�� ���ܵ�)
	}
	
}