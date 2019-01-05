package com.quiz.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.quiz.classes.QuestionBank;
import com.quiz.helperservices.HelperServices;

public class Client {
	public static void main(String[] args) {
		QuestionBank bank = new QuestionBank();
		
		//reading the file from the resources folder
		bank=HelperServices.FileRead("./resources/QuestionBank.txt");
		
		Map<String, List<Integer>> difficultyMap;
		Map<String, List<Integer>> tagMap;
		
		//will give the mapping for the tags
		tagMap = HelperServices.getMapping(bank.getTags());
		System.out.println(tagMap);	
		
		//will give the mapping for the difficulty level
		difficultyMap = HelperServices.getMapping(bank.getDifficultyLevels());
		System.out.println(difficultyMap);
		
		Map<String,Integer> noOfQuestionInTag; 
		Map<String,Integer> noOfQuestionDifficulty; 
		//will give the count of number of questions in each tag
		noOfQuestionInTag = HelperServices.getCount(bank.getTags());
		
		//will give the count of number of questions diffciulty wise
		noOfQuestionDifficulty = HelperServices.getCount(bank.getDifficultyLevels());
		
	}
}
