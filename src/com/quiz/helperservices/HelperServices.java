package com.quiz.helperservices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.quiz.classes.QuestionBank;

public class HelperServices {
	
	//this function will read the file using File Handling and will return a object of QuestionBank
	public static QuestionBank FileRead(String filePath){
		QuestionBank bank = new QuestionBank();
		List<String> questionList = new ArrayList<String>();
		String[] tempList;
		File file = new File(filePath); 

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st; 
			while ((st = br.readLine()) != null){
				tempList = new String[3];
				tempList=st.split("\\|");
				//System.out.println("1 "+tempList[0]+ " 2 "+ tempList[1]+" 3 "+ tempList[2]);
				bank.getQuestionList().add(tempList[0]);
				bank.getDifficultyLevels().add(tempList[1]);
				bank.getTags().add(tempList[2]);
				st=st.trim();
				questionList.add(st);
			}
			//System.out.println(questionList);
			//System.out.println(bank.getTags());
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found:QuestionBank.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return bank;
	}
	
	//helper service for returning the mapping of difficulty levels and tags
	public static Map<String, List<Integer>> getMapping(List<String> list){
		
		Map<String, List<Integer>> tempMap = new HashMap<>();

		for(int i=0;i<list.size();i++){
			if(tempMap.get(list.get(i))==null){
				tempMap.put(list.get(i),new ArrayList<>());
			}
			tempMap.get(list.get(i)).add(i);
		}
		return tempMap;
	}
	
	//helper service for getting count the number of questions in each difficulty levels and tags
	public static Map<String, Integer> getCount(List<String> list){
		Map<String, Integer> tempMap = new HashMap<>();
		Set<String> distinct = new HashSet<>(list);
		
		for(String s: distinct){
			tempMap.put(s,Collections.frequency(list, s));
		}
		//System.out.println(tempMap);
		return tempMap;
	}
	
	//helper service for getting a random question from the given list 
	public static Integer getQuestion(QuestionBank bank, String questionType){
		Integer random = bank.getDifficultyMap().get(questionType).get(new Random().nextInt(bank.getDifficultyMap().get(questionType).size()));
		System.out.println(random);
		modifyCounterVariables(bank, questionType, random);
		return random;
	}
	
	//helper service for changing and modifying the values of counter variables
	public static void modifyCounterVariables(QuestionBank bank, String questionType, Integer questionNumber){
		bank.getDifficultyMap().get(questionType).remove(questionNumber);
		bank.getNoOfQuestionDifficulty().put(questionType,bank.getNoOfQuestionDifficulty().get(questionType)-1);
		
		System.out.println(bank.getNoOfQuestionDifficulty());
		System.out.println(bank.getDifficultyMap());
		
		String tag= bank.getTags().get(questionNumber);
		System.out.println(tag);
		
		bank.getNoOfQuestionInTag().put(tag,bank.getNoOfQuestionInTag().get(tag)-1);
		System.out.println(bank.getNoOfQuestionInTag());
		
		bank.getTagMap().get(tag).remove(questionNumber);
		
		System.out.println(bank.getTagMap());
		
	}
	
	//helper service for checking which tags are not not included yet in the list
	public static Set<String> leftTags(List<Integer> questionSetList,QuestionBank bank){
		Set<String> leftTags = new HashSet<>(bank.getTags());
		Set<String> tempSet = new HashSet<>();
		for(Integer i: questionSetList) {
			tempSet.add(bank.getTags().get(i));
		}
//		System.out.println(leftTags);
//		System.out.println(tempSet);
		leftTags.removeAll(tempSet);
		System.out.println(leftTags);
		return leftTags;
	}
	
	//getting question based on tag instead of difficulty
	public static Integer getQuestionBasedOnTag(QuestionBank bank, String tag){
		Integer random = bank.getTagMap().get(tag).get(new Random().nextInt(bank.getTagMap().get(tag).size()));
		System.out.println("In getQuestionByTag:");
		System.out.println(random);
		modifyCounterVariablesBasedOnTag(bank, tag, random);
		return random;
	}
	
	//helper service for changing and modifying the values of counter variables based on tags
		public static void modifyCounterVariablesBasedOnTag(QuestionBank bank, String tag, Integer questionNumber){
			bank.getTagMap().get(tag).remove(questionNumber);
			bank.getNoOfQuestionInTag().put(tag,bank.getNoOfQuestionInTag().get(tag)-1);
			
			System.out.println(bank.getNoOfQuestionInTag());
			System.out.println(bank.getTagMap());
			
			String difficulty= bank.getDifficultyLevels().get(questionNumber);
			System.out.println(difficulty);
			
			bank.getNoOfQuestionDifficulty().put(difficulty,bank.getNoOfQuestionDifficulty().get(difficulty)-1);
			System.out.println(bank.getNoOfQuestionDifficulty());
			
			bank.getDifficultyMap().get(difficulty).remove(questionNumber);
			
			System.out.println(bank.getDifficultyMap());
			
		}
}
