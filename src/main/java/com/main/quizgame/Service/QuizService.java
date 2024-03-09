package com.main.quizgame.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.main.quizgame.model.Question;
import com.main.quizgame.model.questionform;
import com.main.quizgame.repo.questionrepo;

@Service

public class QuizService {
	@Autowired
	Question question;
	@Autowired
	questionform qform;
	@Autowired
    questionrepo qrepo;
	public questionform getQuestion() {
		List<Question> allquestion=qrepo.findAll();
		//List<Question> only5=new ArrayList <Question>();
		qform.setQuestion(allquestion);
		
		return qform;
	}
	

}
