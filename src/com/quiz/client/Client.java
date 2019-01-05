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
		
		Map<String, List<Integer>> difficultyMap = new HashMap<>();
		Map<String, List<Integer>> tagMap = new HashMap<>();
		
		//will give the mapping for the tags
		tagMap = HelperServices.getMapping(bank.getTags());
		System.out.println(tagMap);	
		
		//will give the mapping for the diffculty level
		difficultyMap = HelperServices.getMapping(bank.getDifficultyLevels());
		System.out.println(difficultyMap);
		
	}
}
