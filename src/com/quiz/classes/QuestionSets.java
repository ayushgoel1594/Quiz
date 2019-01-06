package com.quiz.classes;

import java.util.ArrayList;
import java.util.List;

public class QuestionSets {
	private List <List<Integer>> questionSets;
	private int numberOfQuestionSets;
	
	public QuestionSets() {
		// TODO Auto-generated constructor stub
		questionSets = new ArrayList<>();
		numberOfQuestionSets=0;
	}

	public List<List<Integer>> getQuestionSets() {
		return questionSets;
	}

	public void setQuestionSets(List<List<Integer>> questionSets) {
		this.questionSets = questionSets;
	}

	public int getNumberOfQuestionSets() {
		return numberOfQuestionSets;
	}

	public void setNumberOfQuestionSets(int numberOfQuestionSets) {
		this.numberOfQuestionSets = numberOfQuestionSets;
	}
	
	
}
