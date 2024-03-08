package com.main.quizgame.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String getIndexpage() {
		
		
		return "index.html";
	}
	
	@PostMapping("/login")
	public String loginAuthentication(@RequestParam String username,@RequestParam String password,ModelMap m,RedirectAttributes ra) {
	            
		
		
		
		
		
		return "quizpage.html";
		
	}
	
	
	

}
