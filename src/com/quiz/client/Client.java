package com.quiz.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.quiz.classes.QuestionBank;
import com.quiz.classes.QuestionSets;
import com.quiz.helperservices.HelperServices;

public class Client {
	public static void main(String[] args) {
		QuestionBank bank = new QuestionBank();
		QuestionSets questionSets = new QuestionSets();
		Integer questionNumber=-1;
		
		//this will store the questions in the current set
		List<Integer> questionSetList = new ArrayList<>();
		
		//reading the file from the resources folder
		bank=HelperServices.FileRead("./resources/QuestionBank.txt");
		
		//will give the mapping for the tags
		bank.setTagMap(HelperServices.getMapping(bank.getTags()));
		System.out.println(bank.getTagMap());	
		
		//will give the mapping for the difficulty level
		bank.setDifficultyMap(HelperServices.getMapping(bank.getDifficultyLevels()));
		System.out.println(bank.getDifficultyMap());
		
	
		//will give the count of number of questions in each tag
		bank.setNoOfQuestionInTag(HelperServices.getCount(bank.getTags()));
		System.out.println(bank.getNoOfQuestionInTag());
		
		//will give the count of number of questions difficulty wise
		bank.setNoOfQuestionDifficulty(HelperServices.getCount(bank.getDifficultyLevels()));
		System.out.println(bank.getNoOfQuestionDifficulty());
		
		/* From here we will start implementing the original logic of the program*/
		//getting 2 questions from easy, medium and hard and adding it to the question set list
		questionNumber = HelperServices.getQuestion(bank,"Easy");
		questionSetList.add(questionNumber);		
		questionNumber = HelperServices.getQuestion(bank,"Easy");
		questionSetList.add(questionNumber);
		
		questionNumber = HelperServices.getQuestion(bank,"Medium");
		questionSetList.add(questionNumber);
		questionNumber = HelperServices.getQuestion(bank,"Medium");
		questionSetList.add(questionNumber);
		
		questionNumber = HelperServices.getQuestion(bank,"Hard");
		questionSetList.add(questionNumber);
		questionNumber = HelperServices.getQuestion(bank,"Hard");
		questionSetList.add(questionNumber);
		System.out.println(questionSetList);
		
		//till above we have added 6 questions into the set
		//now we have to add other 4 questions, and it is mandatory to have one question from each tag
		//checking for which tags are not already included in the list
		Set<String> leftTags= HelperServices.leftTags(questionSetList, bank);
		for(String tag: leftTags){
			questionNumber = HelperServices.getQuestionBasedOnTag(bank, tag);
			questionSetList.add(questionNumber);
		}
		//System.out.println(questionSetList);
		Integer noOfQuestionsLeft = 10 - questionSetList.size();
		System.out.println("Number of questions left are:"+noOfQuestionsLeft);
		
		//now we have to add the remaining questions randomly
	}
}
