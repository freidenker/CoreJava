package chapter17;

import java.util.List;

import chapter11.TextFile;

public class WordsCounter {
  public static void main(String[] args) {
	List<String> words=new TextFile("test.txt", "\\W+");
	SimpleHashMap<String, Integer> map=new SimpleHashMap<String,Integer>();
	for(String word:words){
		Integer freq=map.get(word);
		map.put(word, freq == null ? 1:freq+1);
	}
	System.out.println(map);
  }

}
