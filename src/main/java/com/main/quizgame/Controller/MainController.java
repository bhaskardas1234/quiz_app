package com.main.quizgame.Controller;

import java.util.ArrayList;

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
	    public String ansSubmit(@ModelAttribute("qform") questionform qform,ModelMap m) {
		 if(!submitted) {
			 result.setTotalcorrect(quizservice.getResult(qform));
			 quizservice.saveScore(result);
			 submitted=true;
			 
		 }
	       m.addAttribute("result",result);
	        
	        return "result.html"; 
	    }
	 
	 @GetMapping("/scoreboard")
	 public String getScoreBoard(ModelMap m) {
		 ArrayList<Result> slist=(ArrayList<Result>) quizservice.getAllResult();
//	//System.out.println( " is of type " + ((Object)quizservice.getAllResult()).getClass().getSimpleName());  
//		 for(Result a:slist) {
//			 System.out.println(a.getUsername());
//		 }
		 
		 
		 
;		m.addAttribute("slist",slist); 
		 return "scoreBoard.html";
	 }
	
	

}
