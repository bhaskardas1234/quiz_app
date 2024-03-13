package com.main.quizgame.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class questionform {
	public List<Question> questions;


	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	

}
