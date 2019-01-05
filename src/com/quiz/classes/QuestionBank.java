package com.quiz.classes;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
	//Questions list will hold all the questions
	private List<String> questionList;
	//tags will hold all the tags available in the Question Bank
	private List<String> tags;
	//this will hold all the difficulty levels and will have the 1:1 correspondence with the questionList
	private List<String> difficultyLevels;
	
	//this list will hold which question is already used
	private List<String> usedQuestion;
	
	public QuestionBank() {
		// TODO Auto-generated constructor stub
		this.questionList = new ArrayList();
		this.tags = new ArrayList<>();
		this.difficultyLevels = new ArrayList<>();
	}
	public List<String> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<String> getDifficultyLevels() {
		return difficultyLevels;
	}
	public void setDifficultyLevels(List<String> difficultyLevels) {
		this.difficultyLevels = difficultyLevels;
	}
	
}
