package com.main.quizgame.Controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.quizgame.Service.QuizService;
import com.main.quizgame.model.Result;
import com.main.quizgame.model.questionform;

@Controller
public class MainController {
	
	Boolean submitted=false;
	@Autowired
	Result result;
	
	@Autowired
	QuizService quizservice;
	
	@ModelAttribute("result")
	public Result getResult() {
		return result;
	
	}
	
	
	
	@GetMapping("/")
	public String getIndexpage() {
		
		
		return "index.html";
	}
	
	@PostMapping("/login")
	public String loginAuthentication(@RequestParam String username,@RequestParam String password,ModelMap m,RedirectAttributes ra) {
	            
		submitted=false;
		result.setUsername(username);		
		questionform qform=quizservice.getQuestion();
		
		System.out.print("kdfkdjfj");
		m.addAttribute("qform",qform);
		
		
		return "quizpage.html";
		
	}
	 @PostMapping("/submit")
	    public String ansSubmit(@ModelAttribute("qform") questionform qform) {
		 if(!submitted) {
			 result.setTotalcorrect(quizservice.getResult(qform));
			 quizservice.saveScore(result);
			 submitted=true;
			 
		 }
	        
	        
	        return "result.html"; 
	    }
	 
	 @GetMapping("/scoreboard")
	 public String getScoreBoard(ModelMap m) {
		 
		 
	     	 
		 m.addAttribute("slist",quizservice.getAllResult()); 
		 return "scoreBoard.html";
	 }
	
	

}
