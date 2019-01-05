package com.quiz.helperservices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
