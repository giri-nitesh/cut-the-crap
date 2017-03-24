package tokenizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountWords {
	private HashMap<String, Integer> listOfWords = new HashMap<String, Integer>();

	public HashMap<String, Integer> makeWordList() throws IOException{

		File file = new File("//F://Practice//NLP//sample.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		while( (line = br.readLine())!= null ){
			String [] tokens = line.split("\\s+");
			int size=tokens.length;
			while(size>0){
				String word = tokens[size-1]; 
				System.out.println(word);
				int countWord = 0;
				if(!listOfWords.containsKey(word)){                           //add word if it isn't added already
					listOfWords.put(word, 1);								 //first occurrence of this word
				}
				else{
					countWord = listOfWords.get(word) + 1; 
					listOfWords.remove(word);
					listOfWords.put(word, countWord);
				}
				size--;
			}

		}br.close();
		return listOfWords; //return the HashMap you made of distinct words
	}

	public int getDistinctWordCount(){
		return listOfWords.size();
	}

	//get the frequency of the given word
	public int getFrequencyForWord(String word){
		return listOfWords.get(word);
	}

}