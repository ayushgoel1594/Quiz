package com.quiz.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {
	//Questions list will hold all the questions
	private List<String> questionList;
	//tags will hold all the tags available in the Question Bank
	private List<String> tags;
	//this will hold all the difficulty levels and will have the 1:1 correspondence with the questionList
	private List<String> difficultyLevels;
	
	
	private Map<String, List<Integer>> difficultyMap;
	private Map<String, List<Integer>> tagMap;
	
	//this will show the number of questions in each tag
	private Map<String,Integer> noOfQuestionInTag; 
	//this will show the number of questions in each difficulty level
	private Map<String,Integer> noOfQuestionDifficulty; 
	
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

	public Map<String, List<Integer>> getDifficultyMap() {
		return difficultyMap;
	}

	public void setDifficultyMap(Map<String, List<Integer>> difficultyMap) {
		this.difficultyMap = difficultyMap;
	}

	public Map<String, List<Integer>> getTagMap() {
		return tagMap;
	}

	public void setTagMap(Map<String, List<Integer>> tagMap) {
		this.tagMap = tagMap;
	}

	public Map<String, Integer> getNoOfQuestionInTag() {
		return noOfQuestionInTag;
	}

	public void setNoOfQuestionInTag(Map<String, Integer> noOfQuestionInTag) {
		this.noOfQuestionInTag = noOfQuestionInTag;
	}

	public Map<String, Integer> getNoOfQuestionDifficulty() {
		return noOfQuestionDifficulty;
	}

	public void setNoOfQuestionDifficulty(Map<String, Integer> noOfQuestionDifficulty) {
		this.noOfQuestionDifficulty = noOfQuestionDifficulty;
	}

	public List<String> getUsedQuestion() {
		return usedQuestion;
	}

	public void setUsedQuestion(List<String> usedQuestion) {
		this.usedQuestion = usedQuestion;
	}

	//this list will hold which question is already used
	private List<String> usedQuestion;
	
	public QuestionBank() {
		// TODO Auto-generated constructor stub
		this.questionList = new ArrayList<>();
		this.tags = new ArrayList<>();
		this.difficultyLevels = new ArrayList<>();
		
		this.difficultyMap = new HashMap<>();
		this.tagMap = new HashMap<>();
		this.noOfQuestionInTag = new HashMap<>();
		this.noOfQuestionInTag = new HashMap<>();
	}

}
