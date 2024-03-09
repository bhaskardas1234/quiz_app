package com.main.quizgame.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class questionform {
	public List<Question> questions;
	public  List<Question> getQuestion(){
		return questions;
		
	}
	public void setQuestion(List<Question> questions) {
		this.questions=questions;
	}
	
	

}
