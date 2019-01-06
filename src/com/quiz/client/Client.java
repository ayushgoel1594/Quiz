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
		Integer counter;
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
		while(true){
			counter = bank.getQuestionList().size()-   questionSets.getNumberOfQuestionSets()*10;
			int flag=0;
			//if there are less than 10 unique questions remaining, a new set cannot be formed from them
			if(counter<10){
				flag=1;
			}
			//this will check whether any of the tags has no question remaining
			//in such a case loop will break
			for(Integer i: bank.getNoOfQuestionInTag().values()){
				if(i==0){
					flag=1;
				}
			}
			//this will check whether any of the difficulty level has one or less question remaining
			//this will violate the condition that we have to chose 2 questions from each difficulty level
			for(Integer i: bank.getNoOfQuestionDifficulty().values()){
				if(i<=1){
					flag=1;
				}
			}
			//System.out.println(questionSetList);

			if(flag==1){
				break;
			}
			//System.out.println(questionSetList);
			questionSetList = new ArrayList<>();
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
			//System.out.println(questionSetList);

			//till above we have added 6 questions into the set
			//now we have to add other 4 questions, and it is mandatory to have one question from each tag
			//checking for which tags are not already included in the list
			Set<String> leftTags= HelperServices.leftTags(questionSetList, bank);
			//System.out.println("size is:"+questionSetList.size());
			for(String tag: leftTags){
				questionNumber = HelperServices.getQuestionBasedOnTag(bank, tag);
				questionSetList.add(questionNumber);
			}
			//System.out.println(questionSetList);
			Integer noOfQuestionsLeft = 10 - questionSetList.size();
			//System.out.println("Number of questions left are:"+noOfQuestionsLeft);

			//now we have to add the remaining questions randomly
			for(int i=0;i<noOfQuestionsLeft;i++){
				if(bank.getNoOfQuestionDifficulty().get("Easy")> bank.getNoOfQuestionDifficulty().get("Medium") && bank.getNoOfQuestionDifficulty().get("Easy")>bank.getNoOfQuestionDifficulty().get("Hard")){
					questionNumber = HelperServices.getQuestion(bank,"Easy");
					questionSetList.add(questionNumber);
				}
				else if(bank.getNoOfQuestionDifficulty().get("Medium")> bank.getNoOfQuestionDifficulty().get("Easy") && bank.getNoOfQuestionDifficulty().get("Medium")>bank.getNoOfQuestionDifficulty().get("Hard")){
					questionNumber = HelperServices.getQuestion(bank,"Medium");
					questionSetList.add(questionNumber);
				}
				else{
					if(bank.getNoOfQuestionDifficulty().get("Hard")!=0){
						questionNumber = HelperServices.getQuestion(bank,"Hard");
						questionSetList.add(questionNumber);
					}
					else if(bank.getNoOfQuestionDifficulty().get("Medium")!=0){
						questionNumber = HelperServices.getQuestion(bank,"Medium");
						questionSetList.add(questionNumber);
					}
					else{
						questionNumber = HelperServices.getQuestion(bank,"Easy");
						questionSetList.add(questionNumber);
					}
					
				}
			}
			//System.out.println(questionSetList);
			

			questionSets.getQuestionSets().add(questionSetList);
			questionSets.setNumberOfQuestionSets(questionSets.getNumberOfQuestionSets()+1);
		}
		//for(List<Integer> e: ques)
		System.out.println(questionSets.getQuestionSets());
		System.out.println("The number of unique sets made from the given pool are:"+questionSets.getNumberOfQuestionSets());
	}
}
