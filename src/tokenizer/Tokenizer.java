package tokenizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
class Tokenizer{
	public static void main(String args[]) throws IOException{
		File file = new File("//F://Practice//NLP//input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		File fileWriter = new File("//F://Practice//NLP//input.txt");
		BufferedReader brwriter = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String str = null;
		while( (str = br.readLine())!= null ){
			String regex="[\\ ][\\,][\\.][\\;]";
			StringTokenizer st=new StringTokenizer(str,regex,false);
			while(st.hasMoreTokens()){
				System.out.println(st.nextToken());
			}
		}
		br.close();
		CountWords ob=new CountWords();
		HashMap<String, Integer> listOfWords=ob.makeWordList();
		for (Map.Entry<String, Integer> entry : listOfWords.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println(key+" "+value);
		    // ...
		}
		System.out.println(ob.getFrequencyForWord("the"));



	}

}