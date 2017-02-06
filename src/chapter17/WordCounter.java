package chapter17;

import java.util.List;

import chapter11.TextFile;

public class WordCounter {

	public static void main(String[] args) {
		List<String> words=new TextFile("C:\\Users\\chlin\\workspace\\CoreJava\\src\\chapter17\\WordCounter.java", "\\W+");
		AssociativeArray<String, Integer> map=new AssociativeArray<String,Integer>(words.size());
	//	System.out.println(map);
		for(String word:words){
			Integer freq=map.get(word);
			map.put(word, freq == null ? 1 : freq+1); 
		}
		System.out.println("*******************************");
		System.out.println(map);
	}

}
