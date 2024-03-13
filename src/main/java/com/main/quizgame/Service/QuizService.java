package com.main.quizgame.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

import com.main.quizgame.model.Question;
import com.main.quizgame.model.Result;
import com.main.quizgame.model.questionform;
import com.main.quizgame.repo.questionrepo;
import com.main.quizgame.repo.resultrepo;

@Service

public class QuizService {
	@Autowired
	Question question;
	@Autowired
	questionform qform;
	@Autowired
    questionrepo qrepo;
	@Autowired
	resultrepo rrepo;
	public questionform getQuestion() {
		List<Question> allquestion=qrepo.findAll();
		//List<Question> only5=new ArrayList <Question>();
		qform.setQuestions(allquestion);
		
		return qform;
	}
	
	
	
	
	public int getResult(questionform qform) {
		
		int correct=0;
		System.out.println("it  is okk here");
		for( Question q:qform.getQuestions()){
			
			if(q.getAns()==q.getChose())
			{
				correct++;
			}
			
		}
		return correct;
	}
	
	
	
	public void saveScore(Result result) {
		Result saveResult=new Result();
		saveResult.setUsername(result.getUsername());
		saveResult.setTotalcorrect(result.getTotalcorrect());
		
		rrepo.save(saveResult);
		
	}
	
	
	public List<Result> getAllResult(){
		List<Result> allresult=rrepo.findAll();
		return allresult;
	}
	
	
	

}
